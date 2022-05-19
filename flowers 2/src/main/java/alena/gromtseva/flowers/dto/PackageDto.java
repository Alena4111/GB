package alena.gromtseva.flowers.dto;

import javax.persistence.*;

@Entity
@Table(name = "package")
public class PackageDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;
}
