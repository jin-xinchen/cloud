package jin.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
/*
Create table 'payment'(
'id' bigint(20) not null auto_increment comment 'ID',
'serial' varchar(200) DEFAULT '',
PRIMARY KEY('id')
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4

*/