package Repository;

import domain.Compte;
import domain.Partenaire;

import java.util.List;

public interface CompteRepository {
    List<Compte> getAll();
    Compte getById(int id);
    List<Compte>  getByIdP(int id);
    public int add(Compte c);
}
