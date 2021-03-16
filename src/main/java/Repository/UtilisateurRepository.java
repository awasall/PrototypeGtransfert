package Repository;

import domain.Utilisateur;

public interface UtilisateurRepository {
    Utilisateur[] getAll();
    Utilisateur getById(int id);
}
