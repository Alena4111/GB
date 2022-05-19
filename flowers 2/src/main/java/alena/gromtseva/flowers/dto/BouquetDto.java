package alena.gromtseva.flowers.dto;

import javax.persistence.*;

@Entity
@Table(name = "bouquet")
public class BouquetDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "package_id")
    private String packageId;

}
