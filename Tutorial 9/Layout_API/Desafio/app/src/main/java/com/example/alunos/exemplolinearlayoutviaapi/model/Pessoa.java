package com.example.alunos.exemplolinearlayoutviaapi.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pessoa implements Parcelable {
    private String nome;
    private String telefone;

    public Pessoa(String nome, String telefone, int ic_launcher_round){
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }


    protected Pessoa(Parcel in){
        nome = in.readString();
        telefone = in.readString();
    }

    @Override
    public  int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(nome);
        dest.writeString(telefone);
    }



    public static final Parcelable.Creator<Pessoa> CREATOR = new Parcelable.Creator<Pessoa>(){
        public Pessoa createFromParcel(Parcel in){
            return new Pessoa(in);
        }
        public Pessoa[] newArray(int size){
            return new Pessoa[size];
        }

    };
}
