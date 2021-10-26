package  com.emse.spring.faircorp.dao;


import com.emse.spring.faircorp.model.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoomDaoTest {
    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindAHeater() {
        Room Room = roomDao.getOne(-10L);
        Assertions.assertThat(Room.getName()).isEqualTo("Room1");
        Assertions.assertThat(Room.getCurrentTemperature()).isEqualTo(22.3);
    }

    /*Test findByName to find a room by name*/
    @Test
    public void shouldFindARoom() {
        Room Room = roomDao.findByName("Room1");

        System.out.println(Room.toString());
        Assertions.assertThat(Room.getName()).isEqualTo("Room1");
    }
}