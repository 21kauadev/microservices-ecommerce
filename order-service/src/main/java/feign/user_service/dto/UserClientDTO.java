package feign.user_service.dto;

// não preciso de uma cópia completa da entidade User, só o necessário.
public record UserClientDTO(Long id, String name) {
}
