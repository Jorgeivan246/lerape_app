package co.edu.lerape.proyecto.entidades;


import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private String id;

    @Column(nullable=false)
    @NotBlank(message = "Debe de escribir nombre")
    private String nombre;




    @EqualsAndHashCode.Include
    @Email(message = "El correo electrónico no es válido")
    @NotBlank(message = "Debe de escribir su correo electrónico")
    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Column(nullable=false)
    @NotBlank(message = "Debe de escribir su contraseña")
    private String password;


    @ManyToMany(mappedBy = "usuarios")
    private List<Receta> recetas;

    @ManyToMany(mappedBy = "usuarios")
    private List<Patologia> patologias;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
