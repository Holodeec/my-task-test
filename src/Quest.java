import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashSet;

public class Quest {
    public static class EntityLoader {
        public static volatile HashSet<String> CACHE = new HashSet<>(); // todo испальзовать ConcurrentSkipListSet для многопотока
                                                                        // todo 2 - названия переменных с большой буквы только для констант

        public Object synchronizer; // todo модификаторы доступа private
        public String path;

        public EntityLoader(String path) {
            this.synchronizer = new Object();
            this.path = path;
        }

        public void loadEntities() throws Exception {
            if (CACHE.contains(path)) throw  new Exception("Path already");
            CACHE.add(path);

            File file = new File(path);
            File[] files = file.listFiles();
            process(files);
        }

        private void process(File[] files) {
            synchronized (synchronizer) { // todo убрать синхранизацию
                for (File file: files) {
                    processFile(file);
                }
            }
        }
        private void processFile(File file) {
            int maxReadLines = 150;
            BufferedReader br = null; // todo найминг
            String line = null;
            int readed = 0; // todo использовать AtomicInteger().incrementAndGet()

            try {
                br = new BufferedReader(new FileReader(file)); //todo надо закрыть рессурс после использования
                while ((line = br.readLine()) != null && readed < maxReadLines) {
                    store(line); //
                    readed++; // todo использовать AtomicInteger().incrementAndGet()
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void store(String line) {
            try {
                Connection conn = DriverManager.getConnection("..."); //todo найминг
                Statement st = conn.createStatement(); // todo Использовать PrepareStatement
                st.executeUpdate(createStatementString(line));
                st.close(); // todo закрытие ресурсов в блоке finally либо использовать try with resources
                conn.close();
            } catch (Exception e) { // todo использовать более уточняющие исключения
                e.printStackTrace();
            }
        }

        private String createStatementString(String line) {
            return "...";
        }
    }
}
