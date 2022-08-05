String _getPath(String fileName, String format) {
  return '$format/$fileName.$format';
}

final kBeamLogoAsset = _getPath('beam_logo', 'png');
final kThemeModeAsset = _getPath('theme_mode', 'svg');
