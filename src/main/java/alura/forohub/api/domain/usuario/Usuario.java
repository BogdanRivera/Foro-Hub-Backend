package alura.forohub.api.domain.usuario;

import alura.forohub.api.domain.topicos.Topico;
import alura.forohub.api.domain.perfiles.Perfil;
import alura.forohub.api.domain.respuesta.Respuesta;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "Usuario")
@Entity(name = "Usuario")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @ManyToMany
    @JoinTable(
            name = "Usuario_Perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private Set<Perfil> perfiles;

    @OneToMany(mappedBy = "autor")
    private Set<Topico> topicos;

}
