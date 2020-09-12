import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokemonCrudComponent } from './pokemon-crud/pokemon-crud.component';
import {FormsModule,ReactiveFormsModule} from "@angular/forms";
import {InMemoryWebApiModule} from "angular-in-memory-web-api";
import {PokemonDataService} from "./data/PokemonDataService";
import {HttpClientModule} from "@angular/common/http";
import { PokemonListComponent } from './pokeapi/pokemon-list/pokemon-list.component';
import { PokemonDetailComponent } from './pokeapi/pokemon-detail/pokemon-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    PokemonCrudComponent,
    PokemonListComponent,
    PokemonDetailComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        InMemoryWebApiModule.forRoot(PokemonDataService,{passThruUnknownUrl: true}),
        ReactiveFormsModule,
        FormsModule,
        HttpClientModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
