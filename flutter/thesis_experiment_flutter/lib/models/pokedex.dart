import 'package:json_annotation/json_annotation.dart';
import 'package:thesis_experiment/models/pokedex_pokemon.dart';

@JsonSerializable(explicitToJson: true)
class Pokedex {
  const Pokedex({
    required this.pokemon
  });

  final List<PokedexPokemon> pokemon;

  factory Pokedex.fromJson(Map<String, dynamic> json) => _$PokedexFromJson(json);

  Map<String, dynamic> toJson() => _$PokedexToJson(this);
}