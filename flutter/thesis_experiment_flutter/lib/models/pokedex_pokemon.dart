import 'package:json_annotation/json_annotation.dart';

@JsonSerializable(explicitToJson: true)
class PokedexPokemon {
  const PokedexPokemon({
    required this.name,
    required this.url
  });

  @JsonKey(name: 'name')
  final String name;

  @JsonKey(name: 'url')
  final String url;

  factory PokedexPokemon.fromJson(Map<String, dynamic> json) => _$PokedexPokemonFromJson(json);

  Map<String, dynamic> toJson() => _$PokedexPokemonToJson(this);
}