package List;

import VoucherParameters.VoucherType;
import Voucher.Voucher;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import VoucherParameters.*;

public class ListVouchers {

    protected ArrayList<Voucher> list;

    public ListVouchers() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Voucher get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public void add(Voucher voucher) {
        list.add(voucher);
    }

    public List<Voucher> getList() {
        return list;
    }

    public ListVouchers getByType(VoucherType type) {
        ListVouchers filteredVouchers = new ListVouchers();

        list.stream()
                .filter(voucher -> voucher.getType().toString().equals(type.toString()))
                .forEach(filteredVouchers::add);

        return filteredVouchers;
    }

    public ListVouchers getByCountry(Country country) {
        ListVouchers filteredVouchers = new ListVouchers();

        list.stream()
                .filter(voucher -> voucher.getCountry().equals(country))
                .forEach(filteredVouchers::add);

        return filteredVouchers;
    }

    public ListVouchers getByTransport(VoucherTransport transport) {
        ListVouchers filteredVouchers = new ListVouchers();

        list.stream()
                .filter(voucher -> voucher.getTransport().equals(transport))
                .forEach(filteredVouchers::add);

        return filteredVouchers;
    }

    public ListVouchers getByNutrition(Nutrition food) {
        ListVouchers filteredVouchers = new ListVouchers();

        list.stream()
                .filter(voucher -> voucher.getNutrition().equals(food))
                .forEach(filteredVouchers::add);

        return filteredVouchers;
    }

    public ListVouchers getByBudget(Budget budget) {
        ListVouchers filteredVouchers = new ListVouchers();

        list.stream()
                .filter(voucher -> voucher.getBudget().equals(budget))
                .forEach(filteredVouchers::add);

        return filteredVouchers;
    }

    public void sortByPrice(boolean ascending) {
        List<Voucher> sortedList = list.stream()
                .sorted(ascending
                        ? Comparator.comparingInt(Voucher::getPrice)
                        : Comparator.comparingInt(Voucher::getPrice).reversed())
                .toList();
        list.clear();
        list.addAll(sortedList);
    }

    public void sortByDays(boolean ascending) {
        List<Voucher> sortedList = list.stream()
                .sorted(ascending
                        ? Comparator.comparingInt(Voucher::getNumberOfDays)
                        : Comparator.comparingInt(Voucher::getNumberOfDays).reversed())
                .toList();
        list.clear();
        list.addAll(sortedList);
    }

    public void sortByDate(boolean ascending) {
        List<Voucher> sortedList = list.stream()
                .sorted(ascending
                        ? Comparator.comparing(Voucher::getVoucherDate)
                        : Comparator.comparing(Voucher::getVoucherDate).reversed())
                .toList();
        list.clear();
        list.addAll(sortedList);
    }
}