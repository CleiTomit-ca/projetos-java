package br.com.TaskFlow.taskflow_api.service;

import br.com.TaskFlow.taskflow_api.dto.UserCreateDto;
import br.com.TaskFlow.taskflow_api.dto.UserResponseDto;
import br.com.TaskFlow.taskflow_api.dto.UserUpdateDto;
import br.com.TaskFlow.taskflow_api.entity.User;
import br.com.TaskFlow.taskflow_api.exception.EmailDuplicationException;
import br.com.TaskFlow.taskflow_api.exception.IdUserNotFindingException;
import br.com.TaskFlow.taskflow_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDto> listar(){
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(u -> new UserResponseDto(u.getId(), u.getNome(), u.getEmail(), u.getTaskList()))
                .toList();
    }

    public UserResponseDto buscar(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IdUserNotFindingException("Usuário não encontrado"));
        return new UserResponseDto(user.getId(), user.getNome(), user.getEmail(), user.getTaskList());
    }

    public UserResponseDto criar (UserCreateDto dto){
        User user = new User();
        user.setNome(dto.nome());
        if(userRepository.findByEmail(dto.email()).isEmpty()){
            user.setEmail(dto.email());
        }else{
            throw  new EmailDuplicationException("Email já existe");
        }
        User userSalvo = userRepository.save(user);
        return new UserResponseDto(userSalvo.getId(), userSalvo.getNome(), userSalvo.getEmail(), userSalvo.getTaskList());
    }

    public UserResponseDto atualizar(Long userId, UserUpdateDto dto){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IdUserNotFindingException("Usuário não encontrado"));
        user.setNome(dto.nome());
        if(userRepository.findByEmail(dto.email()).isEmpty()){
            user.setEmail(dto.email());
        }else{
            throw new EmailDuplicationException("Email já existe");
        }
        User userSalvo = userRepository.save(user);
        return new UserResponseDto(userSalvo.getId(), userSalvo.getNome(), userSalvo.getEmail(), userSalvo.getTaskList());
    }

    public void deleta(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IdUserNotFindingException("Usuário não encontrado"));
        userRepository.delete(user);
    }

}