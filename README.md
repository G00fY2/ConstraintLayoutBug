# ConstraintLayoutIssue

Minimal project setup to demonstrate ConstraintLayout 2.0.2, 2.0.3 & 2.0.4 issue when using included layouts in specific cases (e.g. RecyclerView): https://issuetracker.google.com/issues/170293243

## Description

Clicking on the "card" rebinds the ViewHolder. This causes one TextView to erroneously dissapear. This does not happen with ConstraintLayout Version 2.0.1.

What's curious about this issue is, that it only happens if the bottom textview "setText" gets called. Also a workaround to prevent the "inner textview" from dissapearing is to call forceLayout().
