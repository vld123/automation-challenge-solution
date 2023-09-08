package challenge.components.world.view;

public class Scripts {

    public static final String getAllPeopleNames =
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var peopleNodes = worldDiagram.findNodesByExample({category: 'person-node-template'}); " +
            " var peopleNames = ''; " +
            " peopleNodes.each(function(node) { " +
            "   peopleNames += node.data.text + ','; " +
            " }); " +
            " return peopleNames; ";

    public static final String getPersonNameByName =
            " console.log('Person to look for: ' + arguments[0]); " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var personNode = worldDiagram.findNodesByExample({category: 'person-node-template', text: arguments[0]}); " +
            " if (personNode.next()) { " +
            "   return personNode.value.data.text; " +
            " } else { " +
            "   return ''; " +
            " } ";

    public static final String getPersonKeyByName =
            " console.log('Person to look for: ' + arguments[0]); " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var personNode = worldDiagram.findNodesByExample({category: 'person-node-template', text: arguments[0]}); " +
            " if (personNode.next()) { " +
            "   return personNode.value.data.key; " +
            " } ";

    public static final String getPersonByName =
            " console.log('Person to look for: ' + arguments[0]); " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var personNode = worldDiagram.findNodesByExample({category: 'person-node-template', text: arguments[0]}); " +
            " if (personNode.next()) { " +
            "   console.log(personNode.value.data); " +
            "   return personNode.value.data; " +
            " } else { " +
            "   return null; " +
            " } ";

    public static final String getAllCountryNames =
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var countryNodes = worldDiagram.findNodesByExample({category: 'country-node-template'}); " +
            " var countryNames = ''; " +
            " countryNodes.each(function(node) { " +
            "   countryNames += node.data.text + ','; " +
            " }); " +
            " return countryNames; ";

    public static final String getCountryNameByName =
            " console.log('Country to look for: ' + arguments[0]); " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var countryNode = worldDiagram.findNodesByExample({category: 'country-node-template', text: arguments[0]}); " +
            " if (countryNode.next()) { " +
            "   return countryNode.value.data.text; " +
            " } else { " +
            "   return ''; " +
            " } ";

    public static final String getCountryKeyByName =
            " console.log('Country to look for: ' + arguments[0]); " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var countryNode = worldDiagram.findNodesByExample({category: 'country-node-template', text: arguments[0]}); " +
            " if (countryNode.next()) { " +
            "   return countryNode.value.data.key; " +
            " } ";

    public static final String getCountryByName =
            " console.log('Country to look for: ' + arguments[0]); " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var countryNode = worldDiagram.findNodesByExample({category: 'country-node-template', text: arguments[0]}); " +
            " if (countryNode.next()) { " +
            "   console.log(countryNode.value.data); " +
            "   return countryNode.value.data; " +
            " } else { " +
            "   return null; " +
            " } ";

    public static final String getCountryByKey =
            " console.log('Country to look for: ' + arguments[0]); " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var countryNode = worldDiagram.findNodesByExample({category: 'country-node-template', key: arguments[0]}); " +
            " if (countryNode.next()) { " +
            "   console.log(countryNode.value.data); " +
            "   return countryNode.value.data; " +
            " } else { " +
            "   return null; " +
            " } ";

    public static final String getAllCountries =
            " var countries = []; var index = 0; " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " var countryNodes = worldDiagram.findNodesByExample({category: 'country-node-template'}); " +
            " countryNodes.each(function(node) { " +
            "   countries[index] = node.data; " +
            "   index++; " +
            " }); " +
            " return countries; ";

    public static final String collapseCountryGroup =
            " console.log('Country to look for: ' + arguments[0]); " +
            " var wasCollapsed = false; " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " const countryNode = worldDiagram.findNodesByExample({category: 'country-node-template', text: arguments[0]}); " +
            " if (countryNode.next()) { " +
            "   countryNode.value.collapseSubGraph(); " +
            "   wasCollapsed = true; " +
            " } " +
            " return wasCollapsed; ";

    public static final String isCountryGroupExpanded =
            " console.log('Country to look for: ' + arguments[0]); " +
            " var isCountryGroupExpanded = true; " +
            " const worldDiagram = document.getElementById('world').goDiagram; " +
            " const countryNode = worldDiagram.findNodesByExample({category: 'country-node-template', text: arguments[0]}); " +
            " if (countryNode.next()) { " +
            "   isCountryGroupExpanded = countryNode.value.isSubGraphExpanded; " +
            " } " +
            " return isCountryGroupExpanded; ";
}
