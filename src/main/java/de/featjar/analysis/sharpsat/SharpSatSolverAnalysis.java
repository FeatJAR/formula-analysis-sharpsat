/* -----------------------------------------------------------------------------
 * formula-analysis-sharpsat - Analysis of propositional formulas using sharpSAT
 * Copyright (C) 2021 Sebastian Krieter
 * 
 * This file is part of formula-analysis-sharpsat.
 * 
 * formula-analysis-sharpsat is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3.0 of the License,
 * or (at your option) any later version.
 * 
 * formula-analysis-sharpsat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with formula-analysis-sharpsat. If not, see <https://www.gnu.org/licenses/>.
 * 
 * See <https://github.com/FeatJAR/formula-analysis-sharpsat> for further information.
 * -----------------------------------------------------------------------------
 */
package de.featjar.analysis.sharpsat;

import de.featjar.analysis.AbstractAnalysis;
import de.featjar.analysis.sharpsat.solver.SharpSatSolver;
import de.featjar.formula.structure.Formula;
import de.featjar.formula.structure.FormulaProvider;

/**
 * Base class for analyses using a {@link SharpSatSolver}.
 *
 * @param <T> Type of the analysis result.
 *
 * @author Sebastian Krieter
 */
public abstract class SharpSatSolverAnalysis<T> extends AbstractAnalysis<T, SharpSatSolver, Formula> {

	protected int timeout = 30;

	public SharpSatSolverAnalysis() {
		super();
		solverInputProvider = FormulaProvider.empty();
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Override
	protected SharpSatSolver createSolver(Formula input) {
		return new SharpSatSolver(input);
	}

	@Override
	protected void prepareSolver(SharpSatSolver solver) {
		super.prepareSolver(solver);
		solver.setTimeout(timeout);
	}

}
