package Repository;

import domain.Compte;
import domain.Depot;

import java.util.List;

public interface DepotRepository {
    List<Depot> getAll();
    Depot getById(int id);
    List<Depot> getByIdC(int id);
    public int add(Depot d);
}
