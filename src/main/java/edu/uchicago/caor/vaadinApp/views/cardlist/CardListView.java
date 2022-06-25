package edu.uchicago.caor.vaadinApp.views.cardlist;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import edu.uchicago.caor.vaadinApp.models.Datum;
import edu.uchicago.caor.vaadinApp.models.TweetsResponse;
import edu.uchicago.caor.vaadinApp.service.AsyncRestCallback;
import edu.uchicago.caor.vaadinApp.service.TweetService;
import edu.uchicago.caor.vaadinApp.views.MainLayout;
import elemental.json.JsonObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Card List")
@Route(value = "card-list", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class CardListView extends Div implements AfterNavigationObserver {

    private TweetService tweetService;
    private Grid<Datum> grid = new Grid<>();
    private String next_token = null;
    private boolean isLoading = false;

    private List<Datum> items = new ArrayList<>();
    private TextField searchText;
    private String searchTerm;

    public CardListView(TweetService tweetService) {
        this.tweetService = tweetService;
        searchText = new TextField();
        searchText.setLabel("Search Term");
        searchText.setPlaceholder("search...");
        searchText.setAutofocus(true);
        searchText.setWidthFull();
        searchText.addKeyDownListener(keyDownEvent -> {
                    String keyStroke = keyDownEvent.getKey().getKeys().toString();
                    if (keyStroke.equals("[Enter]") && !isLoading) {
                        System.out.println(searchText.getValue());
                        searchTerm = searchText.getValue();
                        items.clear();
                        try {
                            getTweets(searchTerm);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        addClassName("card-list-view");
        setSizeFull();
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(item -> createCard(item));
        grid.addItemClickListener(new ComponentEventListener<ItemClickEvent<Datum>>() {
            @Override
            public void onComponentEvent(ItemClickEvent<Datum> itemItemClickEvent) {
                System.out.println(itemItemClickEvent.getItem());
            }
        });

        add(searchText, withClientsideScrollListener(grid));
    }

    private void getTweets(String searchTerm) throws IOException, URISyntaxException {
        isLoading = true;

        AsyncRestCallback<TweetsResponse> cardListCallback = tweetsResponse -> {
            //we must fire this callback on the UI thread and that is why we use getUI().get().acccess(() ->
            getUI().get().access(() -> {
                //this is the callback result, so tweetsResponse is the tweetsResponse returned from
                //      void operationFinished(T results);
                items.addAll(tweetsResponse.getData());
                next_token = tweetsResponse.getMeta().getNextToken();
                grid.setItems(items);
                isLoading = false;
                //https://vaadin.com/docs/v14/flow/advanced/tutorial-push-access
                //we need to notify the browser when we are done. Note that the parent-view MainView is annotated with
                //the @Push annotation, which will force the views to refresh themselves, including the grid.
                getUI().get().push();
            });
        };

        //the callback is expressed as a lambda. We hae access to the members of this class, such as grid, items, etc.
        tweetService.getTweets(cardListCallback, searchTerm, TweetService.MAX_RESULTS, next_token);
        System.out.println(isLoading);
    }

    //we wrap the Vaadin grid with this so that it emits this event at every gridScroll.
    private Grid<Datum> withClientsideScrollListener(Grid<Datum> grid) {
        grid.getElement().executeJs(
                "this.$.scroller.addEventListener('scroll', (scrollEvent) => " +
                        "{requestAnimationFrame(" +
                        "() => $0.$server.onGridScroll({sh: this.$.table.scrollHeight, " +
                        "ch: this.$.table.clientHeight, " +
                        "st: this.$.table.scrollTop}))},true)",
                getElement());
        return grid;
    }

//    //this is called by the javaScript above on the server, which forces the grid fetch records and scroll back to 1/2
//    @ClientCallable
//    public void onGridScroll(JsonObject scrollEvent) throws IOException, URISyntaxException {
//        int scrollHeight = (int) scrollEvent.getNumber("sh");
//        int clientHeight = (int) scrollEvent.getNumber("ch");
//        int scrollTop = (int) scrollEvent.getNumber("st");
//
//        double percentage = (double) scrollTop / (scrollHeight - clientHeight);
//        //reached the absolute bottom of the scroll
//        if (percentage == 1.0) {
//
//            if (!isLoading) {
//                getTweets(searchTerm);
//            }
//            grid.scrollToIndex(items.size() / 2);
//
//        }
//
//    }

    private HorizontalLayout createCard(Datum item) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");

        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        Span author_id = new Span(getAuthorId(item));
        author_id.addClassName("author_id");
        Span text = new Span(getText(item));
        text.addClassName("text");
        header.add(author_id, text);

        description.add(header);
        card.add(description);
        return card;
    }

    private String getAuthorId(Datum item) {
        return item.getAuthorId();
    }

    private String getText(Datum item) {
        return item.getText();
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // we don't need to do anything here now. Possibly remove interface and this contract-method.
    }

}
