package entities;
import java.util.ArrayList;
import java.util.List;


public class MensalInvoicing {

	private List<DailyInvoicing> invoices;

	public MensalInvoicing() {
		this.invoices = new ArrayList<>();
	}

	public void addInvoice(DailyInvoicing invoice) {
		this.invoices.add(invoice);
	}

	public double calculateAverage() {
		double total = 0;
		int daysWithInvoicing = 0;
		for (DailyInvoicing invoice : invoices) {
			if (invoice.getValue() > 0) {
				total += invoice.getValue();
				daysWithInvoicing++;
			}
		}
		return total / daysWithInvoicing;
	}

	public DailyInvoicing findLowestValue() {
		DailyInvoicing lowestValue = null;
		for (DailyInvoicing invoice : invoices) {
			if (lowestValue == null || invoice.getValue() < lowestValue.getValue()) {
				lowestValue = invoice;
			}
		}
		return lowestValue;
	}

	public DailyInvoicing findHighestValue() {
		DailyInvoicing highestValue = null;
		for (DailyInvoicing invoice : invoices) {
			if (highestValue == null || invoice.getValue() > highestValue.getValue()) {
				highestValue = invoice;
			}
		}
		return highestValue;
	}

	public int countDaysAboveAverage() {
		int daysAboveAverage = 0;
		double average = calculateAverage();
		for (DailyInvoicing invoice : invoices) {
			if (invoice.getValue() > average) {
				daysAboveAverage++;
			}
		}
		return daysAboveAverage;
	}

	public void printSummary() {
		double average = calculateAverage();
		DailyInvoicing lowestValue = findLowestValue();
		DailyInvoicing highestValue = findHighestValue();
		int daysAboveAverage = countDaysAboveAverage();
		
		System.out.println("Resumo mensal:");
		System.out.printf("Média diária: R$ %.2f\n", average);
		System.out.println("Menor valor: " + lowestValue.getDate() + " - R$ " + lowestValue.getValue());
		System.out.println("Maior valor: " + highestValue.getDate() + " - R$ " + highestValue.getValue());
		System.out.println("Dias acima da média: " + daysAboveAverage);
	}

	public DailyInvoicing[] getInvoices() {
		// TODO Auto-generated method stub
		return null;
	}
}