package feign.user_service;

import feign.user_service.dto.UserClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// precisarei de um usuario na criação da order.
// aqui será feita a comunicação com outro serviço, no caso,
// o user-service. buscando e acessando a rota onde um usuário
// com o id fornecido é retornado.

@FeignClient(name = "user-service")
public interface UserClient {
    // para que funcione, o user-service deve estar rodando, localmente ou não.
    // é necessário ter uma cópia do tipo de User (um DTO) nesse service também.

    @GetMapping("/users/{id}")
    public UserClientDTO findById(@PathVariable Long id); // implementaçao automatica pelo spring.
}
