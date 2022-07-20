package br.com.dio.desafioreactor;

public record User(Long id,
                   String name,
                   String email,
                   String password,
                   Boolean isAdmin) {

}
