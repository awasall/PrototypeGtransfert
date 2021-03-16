package Repository;

import domain.Partenaire;

import java.util.List;

public interface PartenaireRepository {

    List<Partenaire> getAll();
    Partenaire getById(int id);
    public int add(Partenaire p);


}
