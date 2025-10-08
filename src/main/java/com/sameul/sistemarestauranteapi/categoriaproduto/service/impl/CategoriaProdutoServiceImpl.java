package com.sameul.sistemarestauranteapi.categoriaproduto.service.impl;

import com.sameul.sistemarestauranteapi.categoriaproduto.dto.request.CategoriaProdutoRequest;
import com.sameul.sistemarestauranteapi.categoriaproduto.dto.response.CategoriaProdutoResponse;
import com.sameul.sistemarestauranteapi.categoriaproduto.entity.CategoriaProduto;
import com.sameul.sistemarestauranteapi.categoriaproduto.enums.CategoriaProdutoErrorCode;
import com.sameul.sistemarestauranteapi.categoriaproduto.enums.CategoriaProdutoStatus;
import com.sameul.sistemarestauranteapi.categoriaproduto.mapper.CategoriaProdutoMapper;
import com.sameul.sistemarestauranteapi.categoriaproduto.repository.CategoriaProdutoRepository;
import com.sameul.sistemarestauranteapi.categoriaproduto.service.CategoriaProdutoService;
import com.sameul.sistemarestauranteapi.common.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProdutoServiceImpl implements CategoriaProdutoService {

    private final CategoriaProdutoRepository repository;
    private final CategoriaProdutoMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(CategoriaProdutoServiceImpl.class);
    public CategoriaProdutoServiceImpl(CategoriaProdutoRepository repository, CategoriaProdutoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    @Transactional
    public CategoriaProdutoResponse salvar(CategoriaProdutoRequest request) {
        log.info("[CategoriaProdutoServiceImpl] Iniciando processo para salvar categoria produto: {}", request.getDescricao());
        CategoriaProduto categoriaProduto = mapper.requestToEntity(request);
        categoriaProduto.setStatus(CategoriaProdutoStatus.ATIVO);

        CategoriaProduto categoriaProdutoSalva = repository.save(categoriaProduto);
        log.info("[CategoriaProdutoServiceImpl] Categoria do produto salva com sucesso com ID: {}", categoriaProdutoSalva.getId());
        CategoriaProdutoResponse categoriaMapeada = mapper.categoriaProdutoToResponse(categoriaProdutoSalva);
        return categoriaMapeada;
    }

    @Override
    public CategoriaProdutoResponse buscarPorId(Integer id) {
        CategoriaProduto categoriaProduto = repository.findById(id)
                .orElseThrow(() ->
                        new ObjectNotFoundException(CategoriaProdutoErrorCode.CATEGORIA_PRODUTO_NAO_ENCONTRADA));
        return mapper.categoriaProdutoToResponse(categoriaProduto);
    }

    @Override
    public Page<CategoriaProdutoResponse> listar(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("descricao").ascending());
        return repository.findAll(pageable)
                .map(mapper::categoriaProdutoToResponse);
    }

    @Override
    @Transactional
    public void deletar(Integer id) {
        log.info("[CategoriaProdutoServiceImpl] Buscando categoria do produto para deletar. ID: {}", id);
        CategoriaProduto produto = repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Categoria do Produto não encontrada. ID: {}", id);
                    return new ObjectNotFoundException(CategoriaProdutoErrorCode.CATEGORIA_PRODUTO_NAO_ENCONTRADA);
                });
        repository.delete(produto);
        log.info("[CategoriaProdutoServiceImpl] Categoria do Produto deletada com sucesso. ID: {}", id);
    }
}
