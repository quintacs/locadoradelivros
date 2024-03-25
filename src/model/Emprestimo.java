package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo implements Serializable {

    public Emprestimo() {
    }

    public Emprestimo(String cod, String cpfCliente, String codExemplar, Date dataEmprestimo, Date dataDevolucao, Date dataPrevista) {
        this.cod = cod;
        this.cpfCliente = cpfCliente;
        this.codExemplar = codExemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataPrevista = dataPrevista;
    }

    

    

    
    private Calendar cal = Calendar.getInstance();
    private String cod;
    private String cpfCliente;
    private String codExemplar;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Date dataPrevista;

    /**
     * @return the dataEmprestimo
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * @param dataEmprestimo the dataEmprestimo to set
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the dataPrevista
     */
    public Date getDataPrevista() {
        return dataPrevista;
    }

    /**
     * @param dataPrevista the dataPrevista to set
     */
    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    /**
     * @return the cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return the cpfCliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * @param cpfCliente the cpfCliente to set
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * @return the codExemplar
     */
    public String getCodExemplar() {
        return codExemplar;
    }

    /**
     * @param codExemplar the codExemplar to set
     */
    public void setCodExemplar(String codExemplar) {
        this.codExemplar = codExemplar;
    }
}
