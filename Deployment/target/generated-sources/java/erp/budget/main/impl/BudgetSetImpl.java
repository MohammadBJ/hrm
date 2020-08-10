package erp.budget.main.impl;


import erp.budget.main.Budget;
import erp.budget.main.BudgetSet;
import erp.budget.main.ChapterSet;
import erp.budget.main.impl.ChapterSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class BudgetSetImpl extends InstanceSet<BudgetSet,Budget> implements BudgetSet {

    public BudgetSetImpl() {
    }

    public BudgetSetImpl(Comparator<? super Budget> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setYear( String m_Year ) throws XtumlException {
        for ( Budget budget : this ) budget.setYear( m_Year );
    }
    @Override
    public void setFund( double m_Fund ) throws XtumlException {
        for ( Budget budget : this ) budget.setFund( m_Fund );
    }


    // selections
    @Override
    public ChapterSet R1_Chapter() throws XtumlException {
        ChapterSet chapterset = new ChapterSetImpl();
        for ( Budget budget : this ) chapterset.addAll( budget.R1_Chapter() );
        return chapterset;
    }


    @Override
    public Budget nullElement() {
        return BudgetImpl.EMPTY_BUDGET;
    }

    @Override
    public BudgetSet emptySet() {
      return new BudgetSetImpl();
    }

    @Override
    public BudgetSet emptySet(Comparator<? super Budget> comp) {
      return new BudgetSetImpl(comp);
    }

    @Override
    public List<Budget> elements() {
        return Arrays.asList(toArray(new Budget[0]));
    }

}