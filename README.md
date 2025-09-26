<table>
  <tr>
    <td rowspan="2"><img src="md-images/azur-lane-akashi.gif" width="180"></img></td>
    <td colspan="5">
      <h1> 
        <img src="md-images/dekxi-pfp.png" alt="Dekxi pfp" width="50" height="50"> 
        <img src="https://raw.githubusercontent.com/jmnote/z-icons/master/svg/java.svg" alt="Java Logo" width="50" height="50"> 
        Java Console-based Coursework Template  
      </h1> 
    </td>
  </tr>
  <tr>
    <td colspan="5">
      <b>[INFO]</b>
      &nbspFeel free to copy the code — I don’t really care. If you want to make tweaks or notice anything that needs fixing, go ahead and let me know.
    </td>
  </tr>
</table>

- - -

##  ===== Newest Features =====

- - -

- **ANSI color support**: Customize console rendering with ANSI escape codes (via the provided `Ansi` enum) for colored text and improved readability.

- - -

##  ===== Main Features =====

- - -

- Centralized configuration via ```AppConfig.java```

- Structured logging with ```ConsoleLog.java```

- Input/Output separation with ```ConsoleReader``` and ```ConsolePrinter```

- Clean application flow handled by ```AppRunner``` and ```ConsoleDispatcher```

- Extensible data models in ```model/``` and repository layer in ```repository/```

- Modular business logic in ```service/```

- - -

##  ===== Template Structure =====

- - -

```
src/
├── app/
│   ├── App.java            # Entry point (main method)
│   └── AppRunner.java      # Main loop & application flow
│
├── config/
│   └── AppConfig.java      # Centralized global constants & settings
│
├── controller/
│   └── ListController.java # Handles list operations & delegates to view/model
│
├── data/
│   └── ListData.java       # Data container providing access to list structure
│
├── datastructures/
│   └── LinkedList.java     # Example data structure implementation
│
├── dispatcher/
│   └── ConsoleDispatcher.java  # Handles menu navigation & command dispatching
│
├── log/
│   └── ConsoleLog.java     # Structured logging (DEBUG, ERROR, INFO, SYSTEM)
│
├── repository/
│   └── Repository.java     # Data access layer (abstracted storage/retrieval)
│
├── service/
│   └── Service.java        # Business logic layer
│
├── ui/
│   ├── ConsolePrinter.java # Handles output rendering
│   ├── ConsoleReader.java  # Handles user input
│   └── MenuOptions.java    # Centralized menu definitions
│
└── util/
    ├── Ansi.java           # ANSI styling helpers (colors, effects)
    └── Logger.java         # Logging labels & constants
```
