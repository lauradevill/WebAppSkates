package com.ProyectoWebApp.EmpresaPatinetas.entity.custom;

import com.ProyectoWebApp.EmpresaPatinetas.entity.Client;

public class CountClient {
    //clientes con el número de reservas
    private Integer total;
    private Client client;

    public CountClient(Integer total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
