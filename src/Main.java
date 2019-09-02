import dao.FarmDao;
import dao.FieldDao;
import data.Farm;
import data.Field;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        FarmDao farmDao = new FarmDao();
        FieldDao fieldDao = new FieldDao();

        List<Farm> farms;
        List<Field> fields;

        Farm farm = new Farm(UUID.randomUUID(), "Ферма 1", "Агроном 1", 22.22, 23.23);
        Field field = new Field(UUID.randomUUID(), "Поле 1", 241, new Date(2018, 12, 2), farm.getId());

        System.out.println("Adding");
        fieldDao.add(field);

        System.out.println("Get:");
        fields = fieldDao.getAll();
        for ( Field f : fields ) {
            System.out.println(f.getName());
        }

        System.out.println("Deleting");
        fieldDao.delete(field);

        System.out.println("Get:");
        fields = fieldDao.getAll();

        for ( Field f:fields ) {
            System.out.println(f.getName());
        }
    }

}
