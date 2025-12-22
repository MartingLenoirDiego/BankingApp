package org.banking.dto;

public class TransferRequest {
    private Long accountId;
    private Double amount;
    private String description;
    private Long targetAccountId;
    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getTargetAccountId() {
        return targetAccountId;
    }
    public void setTargetAccountId(Long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }
}
