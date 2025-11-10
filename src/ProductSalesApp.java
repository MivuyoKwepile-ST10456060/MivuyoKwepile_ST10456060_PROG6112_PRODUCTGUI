import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductSalesApp extends JFrame {
    private final JTextArea textArea;
    private final JLabel lblYearsProcessed;
    private final ProductSales sales;

    public ProductSalesApp() {
        super("Product Sales Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        sales = new ProductSales() {
            @Override
            public int[][] GetProductSale() {
                return new int[0][];
            }
        };

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Edit");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);


        JPanel panel = new JPanel();
        JButton btnLoad = new JButton("Load Product Data");
        JButton btnSave = new JButton("Save Product Data");
        panel.add(btnLoad);
        panel.add(btnSave);

        textArea = new JTextArea(8, 30);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);

        lblYearsProcessed = new JLabel("Years Processed: 0", SwingConstants.CENTER);

        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(lblYearsProcessed, BorderLayout.SOUTH);

        btnLoad.addActionListener(e -> loadData());
        btnSave.addActionListener(e -> saveData());
        exitItem.addActionListener(e -> System.exit(0));
        loadItem.addActionListener(e -> loadData());
        saveItem.addActionListener(e -> saveData());
        clearItem.addActionListener(e -> clearData());
    }

    private void loadData() {
        int total = sales.GetTotalSales();
        double avg = sales.GetAverageSales();
        int over = sales.GetSalesOverLimit();
        int under = sales.GetSalesUnderLimit();
        int years = sales.GetProductsProcessed();

        String output = String.format(
                "Total Sales: %d%nAverage Sales: %.0f%nSales over limit: %d%nSales under limit: %d",
                total, avg, over, under
        );

        textArea.setText(output);
        lblYearsProcessed.setText("Years Processed: " + years);
    }

    private void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write("DATA LOG\n");
            writer.write(textArea.getText());
            writer.close();
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data");
        }
    }

    private void clearData() {
        textArea.setText("");
        lblYearsProcessed.setText("Years Processed: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesApp().setVisible(true));
    }
}
