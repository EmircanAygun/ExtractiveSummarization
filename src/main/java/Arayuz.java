import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import opennlp.tools.stemmer.PorterStemmer;
import opennlp.tools.tokenize.SimpleTokenizer;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.graph.api.UndirectedGraph;
import org.gephi.io.exporter.api.ExportController;
import org.gephi.io.importer.api.Container;
import org.gephi.io.importer.api.EdgeDirectionDefault;
import org.gephi.io.importer.api.ImportController;
import org.gephi.io.processor.plugin.DefaultProcessor;
import org.gephi.preview.api.G2DTarget;
import org.gephi.preview.api.PreviewController;
import org.gephi.preview.api.PreviewModel;
import org.gephi.preview.api.PreviewProperty;
import org.gephi.preview.api.RenderTarget;
import org.gephi.preview.types.DependantOriginalColor;
import org.gephi.preview.types.EdgeColor;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.gephi.statistics.plugin.GraphDistance;
import org.gephi.toolkit.demos.plugins.preview.PreviewSketch;
import org.openide.util.Lookup;
import java.awt.TextArea;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.Span;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.openide.util.Exceptions;

public class Arayuz extends javax.swing.JFrame {

    public Arayuz() {
        initComponents();
    }
    public int cumleSayisi=0;
    public String dosyaYolu="";
    public double cbt=0.0; //cümle benzerliği thresholdu
    public double cst=0.0; //cümle skoru thresholdu
    public Double kenarSayisi=0.0;
    public Node[] nodes = new Node[1];
    public List<String> stringList = new ArrayList<>();
    public GraphModel graphModel;
    public GraphModel graphModelNew;
    public String baslik="";
    public TextArea ozetMetin = new TextArea("");
    public TextArea esasMetin = new TextArea("");
    public String ozetMetinString="";
    public String esasMetinString="";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Dosya Seç");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cümle Benzerliği");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thresholdu");

        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cümle Skoru");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thresholdu");

        jTextField3.setEnabled(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        jButton1.setText("Özetle");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Rogue Skoru");

        jTextField1.setEditable(false);

        jButton3.setText("Esas Metin");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Özet Metin");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("√");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("√");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator4)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void nodeCumleAtamasi(){
        // Create a new project
        ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
        pc.newProject();

        // Get the graph model
        graphModel = Lookup.getDefault().lookup(GraphController.class).getGraphModel();
        
        //Add String column
        graphModel.getNodeTable().addColumn("cümle içeriği", String.class);
        graphModel.getNodeTable().addColumn("cümle benzerliği thresholdunu geçen nodeların bağlantı sayısı", int.class);
        graphModel.getNodeTable().addColumn("cümle skoru", Double.class);
        
        int flag=0;
        if(!dosyaYolu.equals("")){
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            String cumle1 = null;
            while ((satir = br.readLine()) != null) {
                String[] cumleler = satir.split("\\.");

                for (String cumle : cumleler) {
                    cumle = cumle.trim();
                    if (!cumle.isEmpty()) {
                        cumle1 = cumle; 
                        if(flag==1){
                            //cumle1=cumle1.concat(" . ");
                            System.out.println("Okunan cümle: " + cumle1);
                            cumleSayisi++; 
                            stringList.add(cumle1);}
                        else {baslik=cumle1;flag=1;}
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}
        Node[] newNodes = new Node[cumleSayisi];
        for (int i = 0; i < cumleSayisi; i++) {
            newNodes[i] = graphModel.factory().newNode("n" + i);
            newNodes[i].setLabel("Cümle "+ (i+1) + ": 0.1");    //("Node "+i)
            newNodes[i].setAttribute("cümle içeriği", stringList.get(i));
            //nodes[i].setAttribute("cümle benzerliği thresholdunu geçen nodeların bağlantı sayısı",2);
            //nodes[i].setAttribute("cümle skoru", 0.3);
            graphModel.getDirectedGraph().addNode(newNodes[i]);
        }
        nodes = newNodes;
        stringList.clear();
    }
    
    public void cumleSkoruHesapla(){
        //skor şu şekilde yazılıyor -> nodes[i].setAttribute("cümle skoru", skor);
        double skor = 0.0;
        double p1=0.0,p2=0.0,p3=0.0,p4=0.0,p5=0.0;
        
        //İŞLEMLER...
        try (InputStream personModelStream = new FileInputStream("C:/Users/emirc/Documents/NetBeansProjects/ExtractiveSummarization/src/main/resources/en-ner-person.bin");
            InputStream locationModelStream = new FileInputStream("C:/Users/emirc/Documents/NetBeansProjects/ExtractiveSummarization/src/main/resources/en-ner-location.bin");
            InputStream organizationModelStream = new FileInputStream("C:/Users/emirc/Documents/NetBeansProjects/ExtractiveSummarization/src/main/resources/en-ner-organization.bin");
            InputStream dateModelStream = new FileInputStream("C:/Users/emirc/Documents/NetBeansProjects/ExtractiveSummarization/src/main/resources/en-ner-date.bin");
            InputStream timeModelStream = new FileInputStream("C:/Users/emirc/Documents/NetBeansProjects/ExtractiveSummarization/src/main/resources/en-ner-time.bin")){

            Tokenizer tokenizer = SimpleTokenizer.INSTANCE;
            
            TokenNameFinderModel personModel = new TokenNameFinderModel(personModelStream);
            NameFinderME personNameFinder    = new NameFinderME(personModel);            
            TokenNameFinderModel locationModel = new TokenNameFinderModel(locationModelStream);
            NameFinderME locationNameFinder    = new NameFinderME(locationModel);            
            TokenNameFinderModel organizationModel = new TokenNameFinderModel(organizationModelStream);
            NameFinderME organizationNameFinder    = new NameFinderME(organizationModel);            
            TokenNameFinderModel dateModel = new TokenNameFinderModel(dateModelStream);
            NameFinderME dateNameFinder    = new NameFinderME(dateModel);            
            TokenNameFinderModel timeModel = new TokenNameFinderModel(timeModelStream);
            NameFinderME timeNameFinder    = new NameFinderME(timeModel);
        
        for (int i = 0; i < cumleSayisi; i++) { // HER BİR CÜMLE BU FOR DÖNGÜSÜ İÇERİSİNDE DÖNÜYOR OLACAK.STRİNG C ÜZERİNDEN İŞLEMLER YAPILACAK.
            skor=0.0;
            
            String c = nodes[i].getAttribute("cümle içeriği").toString();
            
            String[] tokens = tokenizer.tokenize(c);
            
            Span[] personSpans  = personNameFinder.find(tokens);
            int numberOfPersons = personSpans.length;            
            Span[] locationSpans  = locationNameFinder.find(tokens);
            int numberOfLocations = locationSpans.length;            
            Span[] organizationSpans  = organizationNameFinder.find(tokens);
            int numberOfOrganizations = organizationSpans.length;            
            Span[] timeSpans  = timeNameFinder.find(tokens);
            int numberOfTimes = timeSpans.length;
            Span[] dateSpans  = dateNameFinder.find(tokens);
            int numberOfDates = dateSpans.length;
            for (String word : tokens) {
            if (isNumeric(word) && !word.equals(word.toUpperCase())) {
                numberOfDates--;
                }
            }
//            System.out.print("Number of persons: " + numberOfPersons + " / ");
//            System.out.print("Number of locations: " + numberOfLocations + " / ");
//            System.out.print("Number of organizations: " + numberOfOrganizations + " / ");
//            System.out.print("Number of dates: " + numberOfDates + " / ");
//            System.out.println("Number of times: " + numberOfTimes + " / ");

            //System.out.println("sayılar -> "+(numberOfPersons+numberOfLocations+numberOfOrganizations+numberOfDates));
            //*** p1'i tam bulamıyor.özel isim ve tarihlerde sıkıntı çıkıyor
            int totalWords = countWords(c);
            p1 = (numberOfPersons + numberOfLocations + numberOfOrganizations + numberOfDates)/totalWords;
            // SON
            
            
            // ***P2 KISMI***
            int numericCount = countNumericData(c);
            p2 = (double)numericCount / totalWords;
            // SON 
            
            
            // ***P3 KISMI***
            p3 = Double.parseDouble(nodes[i].getAttribute("cümle benzerliği thresholdunu geçen nodeların bağlantı sayısı").toString()) / (cumleSayisi-1);            
            // SON
            
            
            //***P4 KISMI***
            int count = countCommonWords(baslik, c); // baslik'taki kelimelerin kaç tanesinin cümlede geçtiğini bulma
            p4 = (double) count / totalWords;
            // SON
            
            
            // ***P5 KISMI***
            String[] kelimeler = esasMetinString.toLowerCase().split("\\W+");
            // TF değerlerini hesaplamak için kelime frekanslarını saklayan bir harita oluştur
            Map<String, Integer> kelimeFrekanslari = new HashMap<>();
            for (String kelime : kelimeler) {
               kelimeFrekanslari.put(kelime, kelimeFrekanslari.getOrDefault(kelime, 0) + 1);
            }
            // IDF değerlerini hesaplamak için kelimenin metinde kaç kez geçtiğini say
            Map<String, Integer> kelimeGecisSayilari = new HashMap<>();
            for (String kelime : kelimeler) {
                if (!kelimeGecisSayilari.containsKey(kelime)) {
                    kelimeGecisSayilari.put(kelime, 1);
                }
            }
            // TF-IDF değerlerini hesapla ve sakla
            Map<String, Double> tfidfDegerleri = new HashMap<>();
            int toplamKelimeSayisi = kelimeler.length;
            for (String kelime : kelimeFrekanslari.keySet()) {
                double tf = (double) kelimeFrekanslari.get(kelime) / toplamKelimeSayisi;
                double idf = Math.log((double) toplamKelimeSayisi / kelimeGecisSayilari.get(kelime));
                double tfidf = tf * idf;
                tfidfDegerleri.put(kelime, tfidf);
            }
            // TF-IDF değerlerine göre listeyi sırala
            List<Map.Entry<String, Double>> siraliListe = new ArrayList<>(tfidfDegerleri.entrySet());
            siraliListe.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            // En yüksek TF-IDF değerine sahip toplam kelime sayısının yüzde 10'u kadar kelimeleri al
            List<String> enYuksekKelimeler = new ArrayList<>();
            count = Math.min(toplamKelimeSayisi/10, siraliListe.size());
            for (int i2 = 0; i2 < count; i2++) {
                enYuksekKelimeler.add(siraliListe.get(i2).getKey());
            }
            Map<String, Integer> kelimeGecisSayisi = countWordOccurrences(c, enYuksekKelimeler);
            int k=0;
            for (Map.Entry<String, Integer> entry : kelimeGecisSayilari.entrySet()) {
                k++;
            }
            p5 = (double)k/totalWords;
            // SON
            
            
            skor = (double)(p1+p2+p3+p4+p5)/(17.0); // CÜMLENİN NİHAİ SKORU
            System.out.println(skor + "  "+ (p1+p2+p3+p4+p5));
            nodes[i].setAttribute("cümle skoru", skor);
        }
        } catch (IOException e) {
            e.printStackTrace();
          }
            
        //İŞLEMLER SONU
    }
    private static int countNumericData(String sentence) {
        int count = 0;
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (isNumeric(word)) {
                count++;
            }
        }
        return count;
    }
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // Bir string içindeki kelimelerin kaç tanesinin diğer string içinde geçtiğini bulma
    private static int countCommonWords(String s1, String s2) {
        String[] words1 = s1.toLowerCase().split(" ");
        String[] words2 = s2.toLowerCase().split(" ");

        int count = 0;
        for (String word : words1) {
            if (containsWord(words2, word)) {
                count++;
            }
        }
        return count;
    }
    // Bir kelimenin bir string içinde geçip geçmediğini kontrol etme
    private static boolean containsWord(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }
    // Bir string içindeki kelime sayısını bulma
    private static int countWords(String s) {
        String[] words = s.split(" ");
        return words.length;
    }
    private static Map<String, Integer> countWordOccurrences(String cumle, List<String> enYuksekKelimeler) {
        Map<String, Integer> kelimeGecisSayilari = new HashMap<>();

        String[] kelimeler = cumle.toLowerCase().split("\\W+");

        for (String kelime : kelimeler) {
            if (enYuksekKelimeler.contains(kelime)) {
                kelimeGecisSayilari.put(kelime, kelimeGecisSayilari.getOrDefault(kelime, 0) + 1);
            }
        }

        return kelimeGecisSayilari;
    }
    
    public void cumlelerArasıAnlamsalBenzerlikSkoruHesapla() throws IOException {
        //Create edges - skor edge labellarına yazılacak -> e.setLabel(skor);                
        // GloVe modelini yükle
        Map<String, RealVector> wordVectors = loadGloveModel("C:/Users/emirc/Documents/NetBeansProjects/ExtractiveSummarization/src/main/resources/glove.6B.200d.txt");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        for (int i = 0; i < cumleSayisi; i++) {
            String s1 = onIslemeAdimlariUygula(nodes[i].getAttribute("cümle içeriği").toString());
            for (int j = 0; j < cumleSayisi; j++) {
                if(j!=i){
                
                String s2 = onIslemeAdimlariUygula(nodes[j].getAttribute("cümle içeriği").toString());
                
                // Cümleleri vektörlere dönüştür
                RealVector vector1 = sentenceToVector(s1, wordVectors);
                RealVector vector2 = sentenceToVector(s2, wordVectors);
                
                // Kozinüs benzerliğini hesapla
                double similarity = calculateCosineSimilarity(vector1, vector2);

                // Sonucu yazdır
                //System.out.println("Cosine similarity: between " + i + " " + j + ": "+ similarity);
                Edge e = graphModel.factory().newEdge(nodes[i], nodes[j], 0,  true);
                e.setLabel(df.format(similarity)+"");//skor
                graphModel.getDirectedGraph().addEdge(e);
                
                }
            }
        }
    }

    private static Map<String, RealVector> loadGloveModel(String filePath) throws IOException {
        Map<String, RealVector> wordVectors = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(" ");
            String word = values[0];
            double[] vectorValues = new double[values.length - 1];
            for (int i = 1; i < values.length; i++) {
                vectorValues[i - 1] = Double.parseDouble(values[i]);
            }
            RealVector vector = new ArrayRealVector(vectorValues);
            wordVectors.put(word, vector);
        }
        br.close();
        return wordVectors;
    }

    private static RealVector sentenceToVector(String sentence, Map<String, RealVector> wordVectors) {
        String[] words = sentence.toLowerCase().split(" ");
        RealVector vector = new ArrayRealVector(wordVectors.get("a").getDimension());
        for (String word : words) {
            if (wordVectors.containsKey(word)) {
                vector = vector.add(wordVectors.get(word));
            }
        }
        return vector;
    }

    private static double calculateCosineSimilarity(RealVector vector1, RealVector vector2) {
        double dotProduct = vector1.dotProduct(vector2);
        double normProduct = vector1.getNorm() * vector2.getNorm();
        if (normProduct == 0) {
            return 0; // Kesişim kümesi boş olduğunda benzerlik 0'dır.
        }
        return dotProduct / normProduct;
    }
    
    public void cbtGeçenNodeSayisiHesapla(){
        for (int i = 0; i < cumleSayisi; i++) {
            int skor=0;
            for (int j = 0; j < cumleSayisi; j++) {
                if(j!=i){
                    
                    Edge edge = graphModel.getGraph().getEdge(nodes[i], nodes[j]);
                    if(Double.parseDouble(edge.getLabel())>cbt){
                        skor++;
                    }
                }
            }
            nodes[i].setAttribute("cümle benzerliği thresholdunu geçen nodeların bağlantı sayısı", skor);
            //nodes[i].setLabel("Cümle "+ (i+1) + " : "+nodes[i].getAttribute("cümle skoru")+" | "+skor);    
        } 
    }
    
    public String onIslemeAdimlariUygula(String s){
        //TOKENİZATİON
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        String[] tokens = tokenizer.tokenize(s); 
        
        //STEMMİNG
        PorterStemmer porterStemmer = new PorterStemmer();
        for (int i = 0; i < tokens.length; i++) {
            String stem = porterStemmer.stem(tokens[i]);
            tokens[i] = stem;
        }
        
        //STOP-WORDS REMOVE
        String result="";
        Set<String> wordsFromFile = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        try (InputStream inputStream = getClass().getResourceAsStream("/stopwords.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
        String line;
            while ((line = reader.readLine()) != null) {
                wordsFromFile.add(line.trim());
            
            }
            for(int i = 0; i < tokens.length; i++) {
                if(!wordsFromFile.contains(tokens[i])) {
                builder.append(tokens[i]);
                builder.append(' ');
                }
            }
        result = builder.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //PUNCTUATİON REMOVE
        result = result.replaceAll("\\p{Punct}", "");
    
        return result;
    }
    
    // -ÖZETLE BUTONU-
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //***BİR SONRAKİ HESAPLAMA TURU İÇİN YAPILAN DÜZENLEMELER***
        cumleSayisi=0;
        jButton5.setEnabled(false);jTextField2.setEditable(false);
        jButton6.setEnabled(false);jTextField3.setEditable(false);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        graphModel = graphModelNew;
        Node[] newNodes = new Node[1];
        nodes = newNodes;
        //***DÜZENLEMELER SONU***
        
        nodeCumleAtamasi();
        
        // dialogdaki texte esas metini ekleme 
        esasMetin.setText(baslik+"\n\n");
        for (int i = 0; i < nodes.length; i++) {
            esasMetin.append(nodes[i].getAttribute("cümle içeriği").toString()+".\n");
            esasMetinString = esasMetinString.concat(nodes[i].getAttribute("cümle içeriği").toString() + " ");
        }
        
        try {
            cumlelerArasıAnlamsalBenzerlikSkoruHesapla();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        cbtGeçenNodeSayisiHesapla();
        cumleSkoruHesapla();
        
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        for (int i = 0; i < cumleSayisi; i++) {
            nodes[i].setLabel("Cümle "+ (i+1) + " : "+df.format(Double.parseDouble(nodes[i].getAttribute("cümle skoru").toString()))+" | "+(nodes[i].getAttribute("cümle benzerliği thresholdunu geçen nodeların bağlantı sayısı").toString())); 
        }
        

        //Export full graph
        ExportController ec = Lookup.getDefault().lookup(ExportController.class);
        try {
            ec.exportFile(new File("graph.gexf"));
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
       
        //***GRAPHI GÖRSELLEŞTİRME ADIMLARI***
        //Init a project - and therefore a workspace
        ProjectController pc2 = Lookup.getDefault().lookup(ProjectController.class);
        pc2.newProject();
        Workspace workspace2 = pc2.getCurrentWorkspace();

        //Import file
        ImportController importController = Lookup.getDefault().lookup(ImportController.class);
        Container container;
        try {
            File file = new File("C://Users/emirc/Documents/NetBeansProjects/ExtractiveSummarization/graph.gexf");
            container = importController.importFile(file);
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        //Append imported data to GraphAPI
        importController.process(container, new DefaultProcessor(), workspace2);

        //Preview configuration
        PreviewController previewController = Lookup.getDefault().lookup(PreviewController.class);
        PreviewModel previewModel = previewController.getModel();
        previewModel.getProperties().putValue(PreviewProperty.NODE_LABEL_COLOR, new DependantOriginalColor(Color.WHITE));
        previewModel.getProperties().putValue(PreviewProperty.EDGE_LABEL_FONT, new Font("Arial", Font.PLAIN, 18));

        previewModel.getProperties().putValue(PreviewProperty.SHOW_EDGE_LABELS, Boolean.TRUE);
        previewModel.getProperties().putValue(PreviewProperty.SHOW_EDGES, Boolean.TRUE);
        previewModel.getProperties().putValue(PreviewProperty.SHOW_NODE_LABELS, Boolean.TRUE);
        previewModel.getProperties().putValue(PreviewProperty.NODE_LABEL_COLOR, new DependantOriginalColor(Color.WHITE));
        previewModel.getProperties().putValue(PreviewProperty.EDGE_CURVED, Boolean.FALSE);
        previewModel.getProperties().putValue(PreviewProperty.EDGE_OPACITY, 50);
        previewModel.getProperties().putValue(PreviewProperty.BACKGROUND_COLOR, Color.GRAY);

        //New Processing target, get the PApplet
        G2DTarget target = (G2DTarget) previewController.getRenderTarget(RenderTarget.G2D_TARGET);
        final PreviewSketch previewSketch = new PreviewSketch(target);
        previewController.refreshPreview();

        jPanel2.add(previewSketch);
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(previewSketch, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
        //***GRAPH GÖRSELLEŞTİRME SONU***
        
        jButton1.setEnabled(false);
        ozetiCikar();
    }//GEN-LAST:event_jButton1ActionPerformed

    //ÖZET METİN BUTONU
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JDialog d = new JDialog(this, baslik+" - Özet Metin");

        d.add(ozetMetin);
        // setsize of dialog
        d.setSize(600, 300);
        // set visibility of dialog
        d.setVisible(true);
        ozetMetin.setEditable(false);
    }//GEN-LAST:event_jButton4ActionPerformed
    
    //DOSYA SEÇ BUTONU
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      
        int r = j.showOpenDialog(null);

        // EĞER SEÇİM YAPILDIYSA GERÇEKLEŞECEKLER
        if(r == JFileChooser.APPROVE_OPTION){ 
            dosyaYolu = j.getSelectedFile().getAbsolutePath();
            jButton5.setVisible(true);
            jButton5.setEnabled(true);
            jTextField2.setEnabled(true);
            jTextField2.setEditable(true);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    // CÜMLE BENZERLİĞİ THRESHOLDU SEÇME BUTONU
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(!jTextField2.getText().isEmpty()){   
            try
            {
                cbt = Double.parseDouble(jTextField2.getText());
                jButton6.setVisible(true);
                jButton6.setEnabled(true);
                jTextField3.setEnabled(true);
                jTextField3.setEditable(true);

            }
            catch(NumberFormatException e)
            {
                //not a double
                jButton6.setEnabled(false);
                jButton1.setEnabled(false);
                jTextField3.setText("");
                jTextField3.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    // CÜMLE SKORU THRESHOLDU SEÇME BUTONU
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(!jTextField3.getText().isEmpty()){
            try
            {
                cst = Double.parseDouble(jTextField3.getText());
                jButton1.setVisible(true);
                jButton1.setEnabled(true);
            }
            catch(NumberFormatException e)
            {
                //not a double
                jButton1.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    // ESAS METİN BUTONU
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JDialog d = new JDialog(this, baslik+" - Esas Metin");
        
        d.add(esasMetin);
        // setsize of dialog
        d.setSize(600, 300);
        // set visibility of dialog
        d.setVisible(true);
        esasMetin.setEditable(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void ozetiCikar(){
        HashMap<Integer, Double> genelSkor = new HashMap<>();
        
        double CBTGNS_ortalaması=0.0;
        for (int i = 0; i < nodes.length; i++) {
            CBTGNS_ortalaması = CBTGNS_ortalaması + Integer.parseInt(nodes[i].getAttribute("cümle benzerliği thresholdunu geçen nodeların bağlantı sayısı").toString());
        }
        CBTGNS_ortalaması = CBTGNS_ortalaması/nodes.length;
        
        for (int i = 0; i < nodes.length; i++) {
            if(Double.parseDouble(nodes[i].getAttribute("cümle skoru").toString()) >= cst){
                genelSkor.put( i,(Double.parseDouble(nodes[i].getAttribute("cümle skoru").toString())-cst) +
                                 (Integer.parseInt(nodes[i].getAttribute("cümle benzerliği thresholdunu geçen nodeların bağlantı sayısı").toString())-CBTGNS_ortalaması));
                //System.out.println(genelSkor.get(i));
            }
        }
        Map<Integer, Double> hm1 = sortByValue(genelSkor);
        
        // genel skorlara göre sıralanmış cümleleri özet metin dialoguna ekleme
        ozetMetin.setText(baslik+"\n\n");
        for (Map.Entry<Integer, Double> en : hm1.entrySet()) {
            int anahtar = en.getKey();
            //double deger = entry.getValue();
            ozetMetin.append(nodes[anahtar].getAttribute("cümle içeriği").toString()+".\n");
            ozetMetinString = ozetMetinString.concat(nodes[anahtar].getAttribute("cümle içeriği").toString() + " ");
            //System.out.println(en.getValue());
        }
        
        // Rogue Skoru hesaplama
        List<String> kelimeler1 = Arrays.asList(esasMetinString.split("\\s+"));
        List<String> kelimeler2 = Arrays.asList(ozetMetinString.split("\\s+"));

        // Benzer kelimelerin sayısını bulma
        int benzerKelimeSayisi=0;
        for (String kelime1 : kelimeler1) {
            for (String kelime2 : kelimeler2) {
                if (kelime1.equalsIgnoreCase(kelime2)) {
                    benzerKelimeSayisi++;
                    break;
                }
            }
        }

        // Rogue skorunu hesaplama
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        double rogueSkoru = (double) (kelimeler2.size()) / (double) (kelimeler1.size());
        jTextField1.setText("%" + Double.parseDouble(df.format(rogueSkoru))*100);
        System.out.println(rogueSkoru);
    }
    
    public static HashMap<Integer, Double> sortByValue(HashMap<Integer, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Double> > list =
               new LinkedList<Map.Entry<Integer, Double> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double> >() {
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<Integer, Double> temp = new LinkedHashMap<Integer, Double>();
        for (Map.Entry<Integer, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arayuz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
