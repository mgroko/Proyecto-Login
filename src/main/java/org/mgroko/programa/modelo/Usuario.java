package org.mgroko.programa.modelo;

public class Usuario {
    private int idUser;
    private String name;
    private String password;

    public Usuario() {}
    public Usuario(int idUser, String name, String password) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
    }
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
