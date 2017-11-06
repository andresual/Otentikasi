package com.andresual.dev.otentikasi.model;

/**
 * Created by andresual on 9/4/2017.
 */

public class JenisAir {
    private int idPengujianAir;
    private String jenisPengujianAir;

    public JenisAir(int idPengujianAir, String jenisPengujianAir) {
        this.idPengujianAir = idPengujianAir;
        this.jenisPengujianAir = jenisPengujianAir;
    }

    public int getId() {
        return idPengujianAir;
    }

    public void setId(int idPengujianAir) {
        this.idPengujianAir = idPengujianAir;
    }

    public String getJenisPengujianAir() {
        return jenisPengujianAir;
    }

    public void setJenisPengujianAir(String jenisPengujianAir) {
        this.jenisPengujianAir = jenisPengujianAir;
    }
}
