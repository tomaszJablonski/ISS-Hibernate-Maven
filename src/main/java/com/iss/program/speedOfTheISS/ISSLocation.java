package com.iss.program.speedOfTheISS;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "IssLocationNew")
public class ISSLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float latitude;
    private float longitude;
//    private String message;
//    private Long timestamp;

}
