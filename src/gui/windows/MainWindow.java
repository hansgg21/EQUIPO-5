package gui.windows;

import gui.Labels.BarLabel;
import rpg.Player;
import rpg.entities.enemies.Enemy;
import rpg.enu.BarType;
import gui.Labels.NameLabel;
import gui.Labels.GoldLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel topPanel, middlePanel, bottomPanel, juegoPanel;
    private JButton button1, b2, b3, atacarButton, habilidadesButton, huirButton;
    private BarLabel lifeLabel, magicLabel, expLabel;
    private JLabel lifeLabelText, magicLabelText, expLabelText;
    private NameLabel nameLabel;
    private GoldLabel goldLabel;

    private JTextArea textDisplay;
    private JScrollPane textScroll;
    private JPanel actionButtonsPanel;
    private JPanel messageAreaPanel;

    public MainWindow() {
        setTitle("RPG Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createUIComponents();
        addComponentsToFrame();
        addActionListeners();
    }

    private void createUIComponents() {
        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();
        juegoPanel = crearPanelJuego();

        actionButtonsPanel = new JPanel();
        messageAreaPanel = new JPanel();

        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        middlePanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new BorderLayout());

        button1 = new JButton("Botón 1");
        b2 = new JButton("Tiendas");
        b3 = new JButton("Inventario");
        atacarButton = new JButton("Atacar");
        habilidadesButton = new JButton("Habilidades");
        huirButton = new JButton("Salir");

        lifeLabel = new BarLabel(100, 100, BarType.LIFE);
        magicLabel = new BarLabel(30, 100, BarType.MAGIC);
        expLabel = new BarLabel(50, 100, BarType.EXPERIENCE);

        lifeLabelText = new JLabel("Vida:");
        magicLabelText = new JLabel("Magia:");
        expLabelText = new JLabel("Experiencia:");

        nameLabel = new NameLabel("Cowboy");
        goldLabel = new GoldLabel("1000");

        textDisplay = new JTextArea();
        textScroll = new JScrollPane(textDisplay);
        initComponents();
    }

    private void initComponents() {
        textScroll.getViewport().setOpaque(false);
        textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textDisplay.setFont(new Font("Arial", Font.PLAIN, 22));
        textDisplay.setBorder(new EmptyBorder(10, 10, 10, 10));
        textDisplay.setForeground(Color.WHITE);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        textDisplay.setEditable(false);
    }

    private void addComponentsToFrame() {
        topPanel.add(new JLabel("Vida:"));
        topPanel.add(lifeLabel);
        topPanel.add(new JLabel("Magia:"));
        topPanel.add(magicLabel);
        topPanel.add(new JLabel("Experiencia:"));
        topPanel.add(expLabel);

        middlePanel.add(button1);
        middlePanel.add(b2);
        middlePanel.add(b3);

        actionButtonsPanel.setLayout(new GridLayout(1, 3));
        actionButtonsPanel.add(atacarButton);
        actionButtonsPanel.add(habilidadesButton);
        actionButtonsPanel.add(huirButton);

        messageAreaPanel.setLayout(new BorderLayout());
        messageAreaPanel.add(actionButtonsPanel, BorderLayout.WEST);
        messageAreaPanel.add(textScroll, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(juegoPanel, BorderLayout.CENTER); // Mover juegoPanel al centro
        add(messageAreaPanel, BorderLayout.SOUTH);
    }

    private JPanel crearPanelJuego() {
        JPanel panelJuego = new JPanel(new BorderLayout()); // Usar BorderLayout para posicionar elementos
        panelJuego.setBackground(new Color(234, 239, 234));
        panelJuego.setPreferredSize(new Dimension(400, 500));

        // Crear las imágenes
        JLabel imagenJuego = new JLabel(cargarImagenDesdeClasspath("/player.png", 200, 150));
        JLabel segundaImagen = new JLabel(cargarImagenDesdeClasspath("/enemigo.png", 200, 150));

        // Panel para centrar las imágenes horizontalmente
        JPanel imagesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 20));
        if (imagenJuego != null) imagesPanel.add(imagenJuego);
        if (segundaImagen != null) imagesPanel.add(segundaImagen);

        // Colocar el panel de imágenes en la parte inferior
        panelJuego.add(imagesPanel, BorderLayout.SOUTH);

        return panelJuego;
    }



    private ImageIcon cargarImagenDesdeClasspath(String path, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(path));
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception e) {
            System.err.println("No se pudo cargar la imagen: " + path + " - Error: " + e.getMessage());
            return null;
        }
    }

    private void addActionListeners() {
        atacarButton.addActionListener(e -> appendText("¡Has atacado al enemigo!"));
        habilidadesButton.addActionListener(e -> appendText("Mostrando habilidades..."));
        huirButton.addActionListener(e -> System.exit(0));
    }

    public void appendText(String text) {
        textDisplay.append(text + "\n");
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }

    public Enemy getCurrentEnemy() {
        return null;
    }

    public Player getPlayer() {
        return null;
    }

    public void updateEnemyPanel() {
    }

    public void checkGameStatus() {
    }
}
