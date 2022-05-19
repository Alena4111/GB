package alena.gromtseva.flowers.dto;

import javax.persistence.*;

@Entity
@Table(name = "bouquet_detail")
public class BouquetDetailDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "flower_id")
    private String flowerId;

    @Column(name = "bouquet_id")
    private String bouquetId;

    @Column(name = "quantity")
    private String quantity;

}
