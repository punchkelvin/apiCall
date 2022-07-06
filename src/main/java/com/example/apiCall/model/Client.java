package com.example.apiCall.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="client_id")
    private Long client_id;
    @Column(name="client_name")
    private String client_name;
    @Column(name="client_balance")
    private int client_balance;
    @Column(name="client_username")
    private String client_username;
    @Column(name="client_password")
    private String client_password;

    public Client() {
    }

    public Client(@JsonProperty("client_id") Long client_id,
                  @JsonProperty("client_name")String client_name,
                  @JsonProperty("client_balance")int client_balance,
                  @JsonProperty("client_username")String client_username,
                  @JsonProperty("client_password")String client_password) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_balance = client_balance;
        this.client_username = client_username;
        this.client_password = client_password;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getClient_balance() {
        return client_balance;
    }

    public void setClient_balance(int client_balance) {
        this.client_balance = client_balance;
    }

    public String getClient_username() {
        return client_username;
    }

    public void setClient_username(String client_username) {
        this.client_username = client_username;
    }

    public String getClient_password() {
        return client_password;
    }

    public void setClient_password(String client_password) {
        this.client_password = client_password;
    }
}
