package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List <Desenvolvedor> desenvolvedores;
    public Consultoria() {
    }

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<Desenvolvedor>();
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if (desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double total = 0.0;
        if (desenvolvedores != null) {
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                total += desenvolvedor.calcularSalario();
            }
        }
        return total;
    }

    public Integer qtdDesenvolvedoresMobile() {
        int count = 0;

        if (desenvolvedores != null) {
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if (desenvolvedor instanceof DesenvolvedorMobile) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> maiorSalario = new ArrayList<>();

            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if (desenvolvedor.calcularSalario() >= salario) {
                    maiorSalario.add(desenvolvedor);
                }
            }
        return maiorSalario;
    }

    public Desenvolvedor buscarMenorSalario() {
        Double salario = desenvolvedores.get(0).calcularSalario();
        Desenvolvedor nomeDesenvolvedor = desenvolvedores.get(0);
        if(desenvolvedores != null) {
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if (desenvolvedor.calcularSalario() < salario) {
                    salario = desenvolvedor.calcularSalario();
                    nomeDesenvolvedor = desenvolvedor;
                }
            }
        }
        return nomeDesenvolvedor;
    }
    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedoresFiltrados = new ArrayList<>();

        if (desenvolvedores != null && tecnologia != null) {
            for (int i = 0; i < desenvolvedores.size(); i++) {
                Desenvolvedor desenvolvedordaVez = desenvolvedores.get(i);
                if(desenvolvedordaVez instanceof DesenvolvedorWeb){
                    if(((DesenvolvedorWeb) desenvolvedordaVez).getFrontend().contains(tecnologia)){
                        desenvolvedoresFiltrados.add(desenvolvedordaVez);
                    }
                    if(((DesenvolvedorWeb) desenvolvedordaVez).getSgbd().contains(tecnologia)){
                        desenvolvedoresFiltrados.add(desenvolvedordaVez);
                    }
                    if (((DesenvolvedorWeb) desenvolvedordaVez).getBackend().contains(tecnologia)){
                        desenvolvedoresFiltrados.add(desenvolvedordaVez);
                    }


                }
                if(desenvolvedordaVez instanceof DesenvolvedorMobile){
                    if(((DesenvolvedorMobile) desenvolvedordaVez).getPlataforma().contains(tecnologia)){
                        desenvolvedoresFiltrados.add(desenvolvedordaVez);
                    }
                    if(((DesenvolvedorMobile) desenvolvedordaVez).getLinguagem().contains(tecnologia)){
                        desenvolvedoresFiltrados.add(desenvolvedordaVez);
                    }
                }
            }
        }

        return desenvolvedoresFiltrados;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){

    }


    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
