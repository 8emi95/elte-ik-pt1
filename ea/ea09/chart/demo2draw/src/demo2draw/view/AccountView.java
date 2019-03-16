package demo2draw.view;

import chartlib.iface.ChartItem;
import chartlib.scale.EmptyScale;
import chartlib.chart.ColumnChart;
import demo2draw.model.BankAccount;
import demo2draw.model.BankModel;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccountView extends JFrame {

    private BankModel model;
    
    private JPanel columnChart;
    
    public AccountView(BankModel bankModel) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        this.model = bankModel;
        
        int verticalEnd = model.getMaxBalance();
        int verticalinterval = verticalEnd / 12;
        
        columnChart = new ColumnChart(
            new EmptyScale(),
//            new LinearScale(0, verticalEnd, verticalinterval),
            new AccountValueScale(model.getAccounts(), verticalEnd),
            new AccountRenderer(),
            itemize(model.getAccounts())
        );
        
        add(columnChart);
    }

    private Collection<ChartItem> itemize(List<BankAccount> accounts) {
        List<ChartItem> result = new LinkedList<>();
        for(BankAccount ba : accounts) {
            result.add(new AccountItem(ba));
        }
        return result;
    }
    
}
