package pl.allegro.braincode.team10.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "delivery_point_data")
public class DeliveryPointData implements Serializable {

    private static final long serialVersionUID = -5304969281635940348L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "delivery_point_data_seq_generator")
    @SequenceGenerator(
            name = "delivery_point_data_seq_generator",
            sequenceName = "delivery_point_data_id_seq",
            allocationSize = 10
    )
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "inpost_id", unique = true)
    private String inpostId;
    @Basic(optional = false)
    @Column(name = "occupancy")
    private int occupancy;
    @Basic(optional = false)
    @Column(name = "parking")
    private boolean parking;
    @Basic(optional = false)
    @Column(name = "disabled_friendly")
    private boolean disabledFriendly;
    @Basic(optional = false)
    @Column(name = "weekend_pickup")
    private boolean weekendPickup;
    @Basic(optional = false)
    @Column(name = "timeToPickup")
    private int timeToPickup;
}
