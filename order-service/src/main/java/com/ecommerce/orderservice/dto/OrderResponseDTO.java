package com.ecommerce.orderservice.dto;
import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDTO {

    private Long orderId;
    private Long userId;
    private Double totalAmount;
    private String status;
    private LocalDateTime createdAt;
    private List<OrderItemResponseDTO> items;

    // getters & setters
    
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public List<OrderItemResponseDTO> getItems() {
		return items;
	}
	public void setItems(List<OrderItemResponseDTO> items) {
		this.items = items;
	}

}
