package br.com.Produtos.api_produtos.service;
import br.com.Produtos.api_produtos.dtos.ProdutoCreateDto;
import br.com.Produtos.api_produtos.dtos.ProdutoResponseDto;
import br.com.Produtos.api_produtos.dtos.ProdutoUpdateDto;
import br.com.Produtos.api_produtos.entity.Produto;
import br.com.Produtos.api_produtos.execptions.ConflictException;
import br.com.Produtos.api_produtos.execptions.ResourceNotFoundException;
import br.com.Produtos.api_produtos.repository.ProdutoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepositoy produtoRepositoy;

    public Page<ProdutoResponseDto> listar(Pageable pageable) {
        Page<Produto> pList = produtoRepositoy.findAll(pageable);
        return pList.map(p -> new ProdutoResponseDto(p.getId(), p.getNome(), p.getPreco(), p.getQuantidade()));
    }

    public ProdutoResponseDto criar(ProdutoCreateDto dto){
        if(produtoRepositoy.findByNome(dto.nome()).isEmpty()){
            Produto p = new Produto();
            p.setNome(dto.nome());
            p.setPreco(dto.preco());
            p.setQuantidade(dto.quantidade());
            Produto pSalvo = produtoRepositoy.save(p);
            return new ProdutoResponseDto(pSalvo.getId(), pSalvo.getNome(), pSalvo.getPreco(), pSalvo.getQuantidade());
        }
        throw new ConflictException("Produto já existe");
    }

    public ProdutoResponseDto atualizar(Long id, ProdutoUpdateDto dto){
        Produto pUpdate = produtoRepositoy.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Produto não encontrado"));

        pUpdate.setNome(dto.nome());
        pUpdate.setPreco(dto.preco());
        pUpdate.setQuantidade(dto.quantidade());
        Produto psalvo = produtoRepositoy.save(pUpdate);
        return new ProdutoResponseDto(psalvo.getId(), psalvo.getNome(), psalvo.getPreco(), psalvo.getQuantidade());
    }

    public void deletar(Long id){
        Produto produto = produtoRepositoy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        produtoRepositoy.delete(produto);
    }

    public List<ProdutoResponseDto> buscarPorNome(String nome){
        List<Produto> listarNome = produtoRepositoy.findByNome(nome);
        return listarNome.stream()
                .map(p -> new ProdutoResponseDto(p.getId(), p.getNome(), p.getPreco(), p.getQuantidade())).toList();
    }
}
