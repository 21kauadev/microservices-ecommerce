package feign.product_service.dto;

// só o que será necessáriod e product
public record ProductClientDTO(Long id, String name, Double price, Integer stock) {
}
