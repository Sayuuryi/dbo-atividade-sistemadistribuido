package com.sawoo.clienteestoque;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${mensagem.boasvindas:Configuração não carregada}")
    private String mensagem;

    @Value("${server.port:porta não informada}")
    private String porta;

    @GetMapping("/mensagem")
    public String mensagem() {
        return mensagem;
    }

    @GetMapping("/status")
    public String status() {
        if (mensagem.equals("Configuração não carregada")) {
            return "Configuração não carregada. Verifique o Config Server.";
        }

        return "Serviço ativo na porta " + porta + " e configuração carregada com sucesso.";
    }
}
