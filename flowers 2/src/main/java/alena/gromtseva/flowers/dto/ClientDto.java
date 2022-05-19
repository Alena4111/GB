package alena.gromtseva.flowers.dto;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class ClientDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

}
