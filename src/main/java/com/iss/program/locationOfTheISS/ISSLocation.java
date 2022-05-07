package com.iss.program.locationOfTheISS;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "IssLocationNew", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})

}

)
public class ISSLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float latitude;
    private float longitude;

}
