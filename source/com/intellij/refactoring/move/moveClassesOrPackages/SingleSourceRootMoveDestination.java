package com.intellij.refactoring.move.moveClassesOrPackages;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiPackage;
import com.intellij.refactoring.MoveDestination;
import com.intellij.refactoring.PackageWrapper;
import com.intellij.refactoring.util.RefactoringUtil;

import java.util.ArrayList;
import java.util.Collection;

/**
 *  @author dsl
 */
public class SingleSourceRootMoveDestination implements MoveDestination {
  private static final Logger LOG = Logger.getInstance(
    "#com.intellij.refactoring.move.moveClassesOrPackages.SingleSourceRootMoveDestination");
  private final PackageWrapper myPackage;
  private final PsiDirectory myTargetDirectory;

  public SingleSourceRootMoveDestination(PackageWrapper aPackage, PsiDirectory targetDirectory) {
    LOG.assertTrue(aPackage.equalToPackage(targetDirectory.getPackage()));
    myPackage = aPackage;
    myTargetDirectory = targetDirectory;
  }

  public PackageWrapper getTargetPackage() {
    return myPackage;
  }

  public PsiDirectory getTargetIfExists(PsiDirectory source) {
    return myTargetDirectory;
  }

  public PsiDirectory getTargetIfExists(PsiFile source) {
    return myTargetDirectory;
  }

  public PsiDirectory getTargetDirectory(PsiDirectory source) {
    return myTargetDirectory;
  }

  public String verify(PsiFile source) {
    return null;
  }

  public String verify(PsiDirectory source) {
    return null;
  }

  public String verify(PsiPackage source) {
    return null;
  }

  public void analyzeModuleConflicts(final Collection<PsiElement> elements,
                                     ArrayList<String> conflicts) {
    RefactoringUtil.analyzeModuleConflicts(myPackage.getManager().getProject(), elements, myTargetDirectory, conflicts);
  }

  public PsiDirectory getTargetDirectory(PsiFile source) {
    return myTargetDirectory;
  }
}
