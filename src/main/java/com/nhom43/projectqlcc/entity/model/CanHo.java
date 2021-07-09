package com.nhom43.projectqlcc.entity.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Component
//---------
@Entity
@Table(name = "canho")
public class CanHo implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;

    @ToString.Include()
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcanho")
    private long idCanHo;

    // Mapping thông tin biến với tên cột trong Database
    @ToString.Include()
    @NonNull
    @Column(name = "tencanho")
    private String tenCanHo;
    @NonNull
    @Column(name = "mota")
    private String moTa;
    @NonNull
    @Column(name = "dientich")
    private int dienTich;

    // Nếu không đánh dấu @Column thì sẽ mapping tự động theo tên biến
}
