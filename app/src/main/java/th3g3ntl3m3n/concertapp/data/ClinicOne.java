package th3g3ntl3m3n.concertapp.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by th3g3ntl3m3n on 16/8/17.
 */

public class ClinicOne {

    public Map<String, String> getClinicData(int position) {
        position += 1;
        switch (position) {
            case 1:
                return getClinicOneData();
            case 2:
                return getClinicTwoData();
            case 3:
                return getClinicThreeData();
            case 4:
                return getClinicFourData();
            case 5:
                return getClinicFiveData();
            case 6:
                return getClinicSixData();
            case 7:
                return getClinicSevenData();
            case 8:
                return getClinicEightData();
            case 9:
                return getClinicNineData();
            default:
                return null;
        }
    }

    public ArrayList<String> getClinicList(int position) {
        position += 1;
        switch (position) {
            case 1:
                return getClinicOneList();
            case 2:
                return getClinicTwoList();
            case 3:
                return getClinicThreeList();
            case 4:
                return getClinicFourList();
            case 5:
                return getClinicFiveList();
            case 6:
                return getClinicSixList();
            case 7:
                return getClinicSevenList();
            case 8:
                return getClinicEightList();
            case 9:
                return getClinicNineList();
            default:
                return null;
        }
    }

    public ArrayList<String> getClinicOneList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("Jumlah Penduduk");
        values.add("Sasaran Bumil");
        values.add("Sasaran Bayi(Lohir hdp)");
        values.add("Mempunyai Buku KIA/KMS | abs");
        values.add("Mempunyai Buku KIA/KMS | %");
        values.add("K1 | abs");
        values.add("K1 | %");
        values.add("k4 | abs");
        values.add("k4 | %");
        values.add("Status T. Bumil | T1 | abs");
        values.add("Status T. Bumil | T1 | %");
        values.add("Status T. Bumil | T2 | abs");
        values.add("Status T. Bumil | T2 | %");
        values.add("Status T. Bumil | T3 | abs");
        values.add("Status T. Bumil | T3 | %");
        values.add("Status T. Bumil | T4 | abs");
        values.add("Status T. Bumil | T4 | %");
        values.add("Status T. Bumil | T5 | abs");
        values.add("Status T. Bumil | T5 | %");
        values.add("Status T. Bumil | T2+ | abs");
        values.add("Status T. Bumil | T2+ | %");
        values.add("Fe1 | Abs");
        values.add("Fe1 | %");
        values.add("Fe3 | Abs");
        values.add("Fe3 | %");
        values.add("Deteksi Risiko | Tenaga Kesehatan | abs");
        values.add("Deteksi Risiko | Tenaga Kesehatan | %");
        values.add("Deteksi Risiko | Masyarakat | abs");
        values.add("Deteksi Risiko | Masyarakat | %");
        values.add("Rujukan Kasus Risiko Tinggi | Maternal | abs");
        values.add("Rujukan Kasus Risiko Tinggi | Maternal | %");
        values.add("Rujukan Kasus Risiko Tinggi | Neonatal | abs");
        values.add("Rujukan Kasus Risiko Tinggi | Neonatal | %");
        return values;
    }

    public Map<String, String> getClinicOneData() {
        Map<String, String> data = new LinkedHashMap<>();
//        data.put("type", "12345");
//        data.put("month", "12434");
//        data.put("year", "1234");
//        data.put("puskesmas", "123344");
        data.put("jumlah_penduduk", "");
        data.put("sasaran_umil", "");
        data.put("sasaran_bayi", "");
        data.put("mempunyai_buku_abs", "");
        data.put("mempunyai_buku_percent", "");
        data.put("k1_abs", "");
        data.put("k1_percent", "");
        data.put("k4_abs", "");
        data.put("k4_percent", "");
        data.put("status_t1_abs", "");
        data.put("status_t1_percent", "");
        data.put("status_t2_abs", "");
        data.put("status_t2_percent", "");
        data.put("status_t3_abs", "");
        data.put("status_t3_percent", "");
        data.put("status_t4_abs", "");
        data.put("status_t4_percent", "");
        data.put("status_t5_abs", "");
        data.put("status_t5_percent", "");
        data.put("status_t2_add_abs", "");
        data.put("status_t2_add_percent", "");
        data.put("fe1_abs", "");
        data.put("fe1_percent", "");
        data.put("fe3_abc", "");
        data.put("fe3_percent", "");
        data.put("deteksi_risiko_tenaga_kesehatan_abs", "");
        data.put("deteksi_risiko_tenaga_kesehatan_percent", "");
        data.put("deteksi_risiko_masyarakat_abs", "");
        data.put("deteksi_risiko_masyarakat_percent", "");
        data.put("rujukan_kasus_risiko_tinggi_maternal_abs", "");
        data.put("rujukan_kasus_risiko_tinggi_maternal_percent", "");
        data.put("rujukan_kasus_risiko_tinggi_neonatal_abs", "");
        data.put("rujukan_kasus_risiko_tinggi_neonatal_percent", "");
        return data;
    }

    public ArrayList<String> getClinicTwoList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Sasaran | Ibu Bersalin");
        list.add("Sasaran | Ibu Nifas");
        list.add("Bulin ABS %");
        list.add("Persalinan Ditolong Nakes(PN) | PN | Abs");
        list.add("Persalinan Ditolong Nakes(PN) | PN | %");
        list.add("Persalinan Ditolong Nakes(PN) | PN DI FASYANKES | Abs");
        list.add("Persalinan Ditolong Nakes(PN) | PN DI FASYANKES | %");
        list.add("Persalinan Ditolong Nakes(PN) | PN DI NON FASYANKES | Abs");
        list.add("Persalinan Ditolong Nakes(PN) | PN DI NON FASYANKES | %");
        list.add("Persalinan Ditolong Non Nakes | Abs");
        list.add("Persalinan Ditolong Non Nakes | %");
        list.add("VIT A NIFAS | Abs");
        list.add("VIT A NIFAS | %");
        list.add("Kunjungan Nifas(KF) | KF1 | Abs");
        list.add("Kunjungan Nifas(KF) | KF1 | %");
        list.add("Kunjungan Nifas(KF) | KF2 | Abs");
        list.add("Kunjungan Nifas(KF) | KF2 | %");
        list.add("Kunjungan Nifas(KF) | KF3 | Abs");
        list.add("Kunjungan Nifas(KF) | KF3 | %");
        list.add("Kunjungan Neonatal(KN) | KN1 | Abs");
        list.add("Kunjungan Neonatal(KN) | KN1 | %");
        list.add("Kunjungan Neonatal(KN) | KN2 | Abs");
        list.add("Kunjungan Neonatal(KN) | KN2 | %");
        list.add("Kunjungan Neonatal(KN) | KN3 | Abs");
        list.add("Kunjungan Neonatal(KN) | KN3 | %");
        return list;
    }

    public Map<String, String> getClinicTwoData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("sasaran_ibu_bersalin", "");
        map.put("sasaran_ibu_nifas", "");
        map.put("bulin_abs_percent", "");
        map.put("persalinan_ditolong_nakes(pn)_pn_abs", "");
        map.put("persalinan_ditolong_nakes(pn)_pn_percent", "");
        map.put("persalinan_ditolong_nakes(pn)_pn_di_fasyankes_abs", "");
        map.put("persalinan_ditolong_nakes(pn)_pn_di_fasyankes_percent", "");
        map.put("persalinan_ditolong_nakes(pn)_pn_di_non_fasyankes_abs", "");
        map.put("persalinan_ditolong_nakes(pn)_pn_di_non_fasyankes_percent", "");
        map.put("persalinan_ditolong_non_nakes_abs", "");
        map.put("persalinan_ditolong_non_nakes_percent", "");
        map.put("vit_a_nifas_abs", "");
        map.put("vit_a_nifas_percent", "");
        map.put("kunjungan_nifas(kf)_kf1_abs", "");
        map.put("kunjungan_nifas(kf)_kf1_percent", "");
        map.put("kunjungan_nifas(kf)_kf2_abs", "");
        map.put("kunjungan_nifas(kf)_kf2_percent", "");
        map.put("kunjungan_nifas(kf)_kf3_abs", "");
        map.put("kunjungan_nifas(kf)_kf3_percent", "");
        map.put("kunjungan_neonatal(kn)_kn1_abs", "");
        map.put("kunjungan_neonatal(kn)_kn1_percent", "");
        map.put("kunjungan_neonatal(kn)_kn2_abs", "");
        map.put("kunjungan_neonatal(kn)_kn2_percent", "");
        map.put("kunjungan_neonatal(kn)_kn3_abs", "");
        map.put("kunjungan_neonatal(kn)_kn3_percent", "");
        return map;
    }

    public ArrayList<String> getClinicThreeList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("JUMLAH DESA | jmlh desa");
        list.add("JUMLAH DESA | jmlh posyandu");
        list.add("JUMLAH DESA | jmlh Poskesds");
        list.add("JUMLAH DESA | Jmlh Desa Melaksanakan P4K");
        list.add("Jmlh Rumah Tunggu Kelahiran");
        list.add("JUMLAH PUSKESMAS | Jmlh PKM");
        list.add("JUMLAH PUSKESMAS | Jmlh PKM Memiliki Dokter Umum");
        list.add("JUMLAH PUSKESMAS | KM Perawatan | Jmlh");
        list.add("JUMLAH PUSKESMAS | KM Perawatan | Mampu PONED");
        list.add("JUMLAH PUSKESMAS | Jmlh PKM Dengan Ruang Bersalin");
        list.add("JUMLAH PUSKESMAS | Jmlh PKM PKRT");
        list.add("JUMLAH PUSKESMAS | Jmlh PKM Melaks Kelas Ibu Hamil");
        list.add("JUMLAH PUSKESMAS | Jmlh PKM Mampu PP-KtP");
        list.add("JUMLAH PUSKESMAS | Jmlh PKM Melaks Supervisi Fasilit");
        list.add("RUMAH SAKIT | RS Pemerintah | Jmlh RSU");
        list.add("RUMAH SAKIT | RS Pemerintah | Jmlh RSIA");
        list.add("RUMAH SAKIT | RS Swasta | Jmlh RSU");
        list.add("RUMAH SAKIT | RS Swasta | Jmlh RSIA");
        list.add("RUMAH SAKIT | Jmlh RS Mampu PONEK");
        list.add("RUMAH SAKIT | Jmlh RS PPT / PKT");
        list.add("Jmlh Fasyankes Mampu Pelayanan KB Sesuai | RSU Pemerintah");
        list.add("Jmlh Fasyankes Mampu Pelayanan KB Sesuai | PKM");
        list.add("Jmlh Fasyankes Mampu Pelayanan KB Sesuai | Pustu");
        list.add("Jmlh Fasyankes Mampu Pelayanan KB Sesuai | Poskesdes");
        list.add("Jmlh Fasyankes Mampu Pelayanan KB Sesuai | Jmlh Total");
        list.add("Dokter Umum (DU) | Jmlh Total DU");
        list.add("Dokter Umum (DU) | Jmlh DU di PKM");
        list.add("Dokter Spesialis | Jmlh SpOG (Obgin)");
        list.add("Dokter Spesialis | Jmlh SpA (Anak)");
        list.add("Dokter Spesialis | Jmlh SpAn (Anastesi)");
        list.add("Bidan | Jmlh Total Bidan");
        list.add("Bidan | Jmlah Bidan di PKM");
        list.add("Bidan | Jmlh Bidan di Desa (BDD)");
        list.add("Bidan | Jmlh BDD Tinggal di Desa");
        list.add("Bidan | Jmlh BDD Punya Bidan KIT");
        list.add("Dukun Beranak | Jmlh Dukun");
        list.add("Dukun Beranak | Jmlh Dukun Bermitra");
        return list;
    }

    public Map<String, String> getClinicThreeData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("jumlah_desa_jmlh_desa", "");
        map.put("jumlah_desa_jmlh_posyandu", "");
        map.put("jumlah_desa_jmlh_poskesds", "");
        map.put("jumlah_desa_jmlh_desa_melaksanakan_p4k", "");
        map.put("jmlh_rumah_tunggu_kelahiran", "");
        map.put("jumlah_puskesmas_jmlh_pkm", "");
        map.put("jumlah_puskesmas_jmlh_pkm_memiliki_dokter_umum", "");
        map.put("jumlah_puskesmas_km_perawatan_jmlh", "");
        map.put("jumlah_puskesmas_km_perawatan_mampu_poned", "");
        map.put("jumlah_puskesmas_jmlh_pkm_dengan_ruang_bersalin", "");
        map.put("jumlah_puskesmas_jmlh_pkm_pkrt", "");
        map.put("jumlah_puskesmas_jmlh_pkm_melaks_kelas_ibu_hamil", "");
        map.put("jumlah_puskesmas_jmlh_pkm_mampu_pp-ktp", "");
        map.put("jumlah_puskesmas_jmlh_pkm_melaks_supervisi_fasilit", "");
        map.put("rumah_sakit_rs_pemerintah_jmlh_rsu", "");
        map.put("rumah_sakit_rs_pemerintah_jmlh_rsia", "");
        map.put("rumah_sakit_rs_swasta_jmlh_rsu", "");
        map.put("rumah_sakit_rs_swasta_jmlh_rsia", "");
        map.put("rumah_sakit_jmlh_rs_mampu_ponek", "");
        map.put("rumah_sakit_jmlh_rs_ppt_or_pkt", "");
        map.put("jmlh_fasyankes_mampu_pelayanan_kb_sesuai_rsu_pemerintah", "");
        map.put("jmlh_fasyankes_mampu_pelayanan_kb_sesuai_pkm", "");
        map.put("jmlh_fasyankes_mampu_pelayanan_kb_sesuai_pustu", "");
        map.put("jmlh_fasyankes_mampu_pelayanan_kb_sesuai_poskesdes", "");
        map.put("jmlh_fasyankes_mampu_pelayanan_kb_sesuai_jmlh_total", "");
        map.put("dokter_umum_(du)_jmlh_total_du", "");
        map.put("dokter_umum_(du)_jmlh_du_di_pkm", "");
        map.put("dokter_spesialis_jmlh_spog_(obgin)", "");
        map.put("dokter_spesialis_jmlh_spa_(anak)", "");
        map.put("dokter_spesialis_jmlh_span_(anastesi)", "");
        map.put("bidan_jmlh_total_bidan", "");
        map.put("bidan_jmlah_bidan_di_pkm", "");
        map.put("bidan_jmlh_bidan_di_desa_(bdd)", "");
        map.put("bidan_jmlh_bdd_tinggal_di_desa", "");
        map.put("bidan_jmlh_bdd_punya_bidan_kit", "");
        map.put("dukun_beranak_jmlh_dukun", "");
        map.put("dukun_beranak_jmlh_dukun_bermitra", "");
        return map;
    }

    public ArrayList<String> getClinicFourList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("JUMLAH KEMATIAN IBU | Total Kematian Ibu");
        list.add("JUMLAH KEMATIAN IBU | Sebab Kematian Ibu | Perdarahan");
        list.add("JUMLAH KEMATIAN IBU | Sebab Kematian Ibu | Hipertensi Dalam Kehamilan");
        list.add("JUMLAH KEMATIAN IBU | Sebab Kematian Ibu | Abortus");
        list.add("JUMLAH KEMATIAN IBU | Sebab Kematian Ibu | Partus Lama ");
        list.add("JUMLAH KEMATIAN IBU | Sebab Kematian Ibu | Lain-lain");
        list.add("Keadaan Lahir | Lahir Hidup");
        list.add("Keadaan Lahir | Lahir Mati");
        list.add("Jumlah Kematian Neonatal | Umur | < 1 Minggu");
        list.add("Jumlah Kematian Neonatal | Umur | 1 mgg - 1 Bln");
        list.add("Jumlah Kematian Neonatal | Total Kematian Neonatal");
        list.add("Jumlah Kematian Neonatal | Sebab Kematian Neonatal | BBLR");
        list.add("Jumlah Kematian Neonatal | Sebab Kematian Neonatal | Asfiksia");
        list.add("Jumlah Kematian Neonatal | Sebab Kematian Neonatal | Tetanus");
        list.add("Jumlah Kematian Neonatal | Sebab Kematian Neonatal | Infeksi");
        list.add("Jumlah Kematian Neonatal | Sebab Kematian Neonatal | Masalah Laktasi");
        list.add("Jumlah Kematian Neonatal | Sebab Kematian Neonatal | Lain-lain");
        return list;
    }

    public Map<String, String> getClinicFourData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("jumlah_kematian_ibu_total_kematian_ibu", "");
        map.put("jumlah_kematian_ibu_sebab_kematian_ibu_perdarahan", "");
        map.put("jumlah_kematian_ibu_sebab_kematian_ibu_hipertensi_dalam_kehamilan", "");
        map.put("jumlah_kematian_ibu_sebab_kematian_ibu_abortus", "");
        map.put("jumlah_kematian_ibu_sebab_kematian_ibu_partus_lama", "");
        map.put("jumlah_kematian_ibu_sebab_kematian_ibu_lain-lain", "");
        map.put("keadaan_lahir_lahir_hidup", "");
        map.put("keadaan_lahir_lahir_mati", "");
        map.put("jumlah_kematian_neonatal_umur_lesser_1_minggu", "");
        map.put("jumlah_kematian_neonatal_umur_1_mgg_bt_1_bln", "");
        map.put("jumlah_kematian_neonatal_total_kematian_neonatal", "");
        map.put("jumlah_kematian_neonatal_sebab_kematian_neonatal_bblr", "");
        map.put("jumlah_kematian_neonatal_sebab_kematian_neonatal_asfiksia", "");
        map.put("jumlah_kematian_neonatal_sebab_kematian_neonatal_tetanus", "");
        map.put("jumlah_kematian_neonatal_sebab_kematian_neonatal_infeksi", "");
        map.put("jumlah_kematian_neonatal_sebab_kematian_neonatal_masalah_laktasi", "");
        map.put("jumlah_kematian_neonatal_sebab_kematian_neonatal_lain_lain", "");
        return map;
    }

    public ArrayList<String> getClinicFiveList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Jmlh Kehamilan Remaja (15-19 Thn)");
        list.add("Hb | Diperiksa HB");
        list.add("Hb | Anemia (8-11 mg/dl)");
        list.add("Hb | Anemia (< 8 mg/dl)");
        list.add("KEK | Diperiksa LILA");
        list.add("KEK | KEK (LILA < 23,5 cm)");
        list.add("Protein Urin | Diperiksa");
        list.add("Protein Urin | Positif (+)");
        list.add("Gula Darah (GD) | Diperiksa");
        list.add("Gula Darah (GD) | GD > 140 g/dl");
        list.add("Integrasi Program | Ibu Hamil Datang Dengan HIV (+)");
        list.add("Integrasi Program | Ibu Hamil Ditawarkan Test HIV");
        list.add("Integrasi Program | Ibu Hamil Ditest HIV");
        list.add("Integrasi Program | Ibu Hamil Hasil Test HIV (+)");
        list.add("Integrasi Program | Ibu Hamil Mendapat ART");
        list.add("Integrasi Program | Ibu Hamil HIV (+) | Persalinan Pervaginam");
        list.add("Integrasi Program | Ibu Hamil HIV (+) | Persalinan perabdominam (SC)");
        return list;
    }

    public Map<String, String> getClinicFiveData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("jmlh_kehamilan_remaja_(15-19_thn)", "");
        map.put("hb_diperiksa_hb", "");
        map.put("hb_anemia_(8-11_mg/dl)", "");
        map.put("hb_anemia_(<_8_mg/dl)", "");
        map.put("kek_diperiksa_lila", "");
        map.put("kek_kek_(lila_<_23,5_cm)", "");
        map.put("protein_urin_diperiksa", "");
        map.put("protein_urin_positif_(+)", "");
        map.put("gula_darah_(gd)_diperiksa", "");
        map.put("gula_darah_(gd)_gd_>_140_g/dl", "");
        map.put("integrasi_program_ibu_hamil_datang_dengan_hiv_(+)", "");
        map.put("integrasi_program_ibu_hamil_ditawarkan_test_hiv", "");
        map.put("integrasi_program_ibu_hamil_ditest_hiv", "");
        map.put("integrasi_program_ibu_hamil_hasil_test_hiv_(+)", "");
        map.put("integrasi_program_ibu_hamil_mendapat_art", "");
        map.put("integrasi_program_ibu_hamil_hiv_(+)_persalinan_pervaginam", "");
        map.put("integrasi_program_ibu_hamil_hiv_(+)_persalinan_perabdominam_(sc)", "");
        return map;
    }

    public ArrayList<String> getClinicSixList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Pencegahan Malaria Dalam Kehamilan | Ibu Hamil Mendapatkan Kelambu");
        list.add("Pencegahan Malaria Dalam Kehamilan | Ibu Hamil Diperiksa Mikroskopis/RDT");
        list.add("Pencegahan Malaria Dalam Kehamilan | Ibu Hamil Malaria (+)");
        list.add("Pencegahan Malaria Dalam Kehamilan | Ibu Hamil Mendapatkan Kina/ACT");
        list.add("TB Dalam Kehamilan | Ibu Hamil Diperiksa Dahak");
        list.add("TB Dalam Kehamilan | Ibu Hamil Hasil Dahak TB (+)");
        list.add("TB Dalam Kehamilan | Obat* *");
        list.add("Kecacingan Dalam Kehamilan | Ibu Hamil Diperiksa Ankylostoma");
        list.add("Kecacingan Dalam Kehamilan | Ibu Hamil Hasil Test Ankylostoma (+)");
        list.add("Kecacingan Dalam Kehamilan | Ibu Hamil Diobati");
        list.add("Pencegahan IMS Dalam Kehamilan | Ibu Hamil Diperiksa IMS");
        list.add("Pencegahan IMS Dalam Kehamilan | Ibu Hamil Hasil Test IMS (+)");
        list.add("Pencegahan IMS Dalam Kehamilan | Ibu Hamil Diobati");
        list.add("Pencegahan Hepatitis B Dalam Kehamilan | Ibu Hamil Diperiksa Hepatitis B");
        list.add("Pencegahan Hepatitis B Dalam Kehamilan | Ibu Hamil Hasil Test Hep B (+)");
        list.add("Pencegahan Hepatitis B Dalam Kehamilan | Ibu Hamil Diobati");

        return list;
    }

    public Map<String, String> getClinicSixData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pencegahan_malaria_dalam_kehamilan_ibu_hamil_mendapatkan_kelambu", "");
        map.put("pencegahan_malaria_dalam_kehamilan_ibu_hamil_diperiksa_mikroskopis/rdt", "");
        map.put("pencegahan_malaria_dalam_kehamilan_ibu_hamil_malaria_(+)", "");
        map.put("pencegahan_malaria_dalam_kehamilan_ibu_hamil_mendapatkan_kina/act", "");
        map.put("tb_dalam_kehamilan_ibu_hamil_diperiksa_dahak", "");
        map.put("tb_dalam_kehamilan_ibu_hamil_hasil_dahak_tb_(+)", "");
        map.put("tb_dalam_kehamilan_obat*_*", "");
        map.put("kecacingan_dalam_kehamilan_ibu_hamil_diperiksa_ankylostoma", "");
        map.put("kecacingan_dalam_kehamilan_ibu_hamil_hasil_test_ankylostoma_(+)", "");
        map.put("kecacingan_dalam_kehamilan_ibu_hamil_diobati", "");
        map.put("pencegahan_ims_dalam_kehamilan_ibu_hamil_diperiksa_ims", "");
        map.put("pencegahan_ims_dalam_kehamilan_ibu_hamil_hasil_test_ims_(+)", "");
        map.put("pencegahan_ims_dalam_kehamilan_ibu_hamil_diobati", "");
        map.put("pencegahan_hepatitis_b_dalam_kehamilan_ibu_hamil_diperiksa_hepatitis_b", "");
        map.put("pencegahan_hepatitis_b_dalam_kehamilan_ibu_hamil_hasil_test_hep_b_(+)", "");
        map.put("pencegahan_hepatitis_b_dalam_kehamilan_ibu_hamil_diobati", "");

        return map;
    }

    public ArrayList<String> getClinicSevenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Puskesmas Yang Melaksanakan Kelas Ibu Hamil");
        list.add("Jumlah Kelas Ibu Hamil Yang Terbentuk");
        list.add("Jumlah Ibu Hamil Yang Mengikuti Kelas Ibu Hamil");
        list.add("Jumlah Suami/Keluarga Yang Mengikuti Kelas Ibu Hamil");
        list.add("Jumlah Bidan Yang Melakukan Kelas Ibu Hamil");
        return list;
    }

    public Map<String, String> getClinicSevenData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("puskesmas_yang_melaksanakan_kelas_ibu_hamil", "");
        map.put("jumlah_kelas_ibu_hamil_yang_terbentuk", "");
        map.put("jumlah_ibu_hamil_yang_mengikuti_kelas_ibu_hamil", "");
        map.put("jumlah_suami/keluarga_yang_mengikuti_kelas_ibu_hamil", "");
        map.put("jumlah_bidan_yang_melakukan_kelas_ibu_hamil", "");
        return map;
    }

    public ArrayList<String> getClinicEightList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Sasaran | Jlh PUS");
        list.add("Sasaran | Jlh PUS Miskin");
        list.add("Sasaran | Jlh PUS 4T");
        list.add("Pelayanan Keluarga Berencana | KB Aktif | Abs");
        list.add("Pelayanan Keluarga Berencana | KB Aktif | %");
        list.add("Pelayanan Keluarga Berencana | Komplikasi | Abs");
        list.add("Pelayanan Keluarga Berencana | Komplikasi | %");
        list.add("Pelayanan Keluarga Berencana | Kegagalan | Abs");
        list.add("Pelayanan Keluarga Berencana | Kegagalan | %");
        list.add("Pelayanan Keluarga Berencana | Drop Out | Abs");
        list.add("Pelayanan Keluarga Berencana | Drop Out | %");
        list.add("Pelayanan Keluarga Berencana | PUS Miskin Ber KB | Abs");
        list.add("Pelayanan Keluarga Berencana | PUS Miskin Ber KB | %");
        list.add("Pelayanan Keluarga Berencana | PUS 4T Ber KB | Abs");
        list.add("Pelayanan Keluarga Berencana | PUS 4T Ber KB | %");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penerimaan | Pil");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penerimaan | Suntik");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penerimaan | AKDR");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penerimaan | Implant");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penerimaan | Kondom");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penggunaan | Pil");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penggunaan | Suntik");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penggunaan | AKDR");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penggunaan | Implant");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Penggunaan | Kondom");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Sisa | Pil");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Sisa | Suntik");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Sisa | AKDR");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Sisa | Implant");
        list.add("Pemantauan Persediaan Alat Kontrasepsi | Sisa | Kondom");
        return list;
    }

    public Map<String, String> getClinicEightData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("sasaran_jlh_pus", "");
        map.put("sasaran_jlh_pus_miskin", "");
        map.put("sasaran_jlh_pus_4t", "");
        map.put("pelayanan_keluarga_berencana_kb_aktif_abs", "");
        map.put("pelayanan_keluarga_berencana_kb_aktif_percent", "");
        map.put("pelayanan_keluarga_berencana_komplikasi_abs", "");
        map.put("pelayanan_keluarga_berencana_komplikasi_percent", "");
        map.put("pelayanan_keluarga_berencana_kegagalan_abs", "");
        map.put("pelayanan_keluarga_berencana_kegagalan_percent", "");
        map.put("pelayanan_keluarga_berencana_drop_out_abs", "");
        map.put("pelayanan_keluarga_berencana_drop_out_percent", "");
        map.put("pelayanan_keluarga_berencana_pus_miskin_ber_kb_abs", "");
        map.put("pelayanan_keluarga_berencana_pus_miskin_ber_kb_percent", "");
        map.put("pelayanan_keluarga_berencana_pus_4t_ber_kb_abs", "");
        map.put("pelayanan_keluarga_berencana_pus_4t_ber_kb_percent", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penerimaan_pil", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penerimaan_suntik", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penerimaan_akdr", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penerimaan_implant", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penerimaan_kondom", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penggunaan_pil", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penggunaan_suntik", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penggunaan_akdr", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penggunaan_implant", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_penggunaan_kondom", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_sisa_pil", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_sisa_suntik", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_sisa_akdr", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_sisa_implant", "");
        map.put("pemantauan_persediaan_alat_kontrasepsi_sisa_kondom", "");
        return map;
    }

    public ArrayList<String> getClinicNineList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Jenis Kekerasan Terhadap Perempuan | Mental | 15-44");
        list.add("Jenis Kekerasan Terhadap Perempuan | Mental | 45-60");
        list.add("Jenis Kekerasan Terhadap Perempuan | Mental | > 60");
        list.add("Jenis Kekerasan Terhadap Perempuan | Fisik |  15-44");
        list.add("Jenis Kekerasan Terhadap Perempuan | Fisik |  45-60");
        list.add("Jenis Kekerasan Terhadap Perempuan | Fisik |  > 60");
        list.add("Jenis Kekerasan Terhadap Perempuan | Emosional | 15-44");
        list.add("Jenis Kekerasan Terhadap Perempuan | Emosional | 45-60");
        list.add("Jenis Kekerasan Terhadap Perempuan | Emosional | > 60");
        list.add("Jenis Kekerasan Terhadap Perempuan | Penelantaran | 15-44");
        list.add("Jenis Kekerasan Terhadap Perempuan | Penelantaran | 45-60");
        list.add("Jenis Kekerasan Terhadap Perempuan | Penelantaran | > 60");
        list.add("Penanganan | Puskesmas / RS");
        list.add("Penanganan | Dirujuk");
        list.add("Penanganan | Lain-lain");
        return list;
    }

    public Map<String, String> getClinicNineData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("jenis_kekerasan_terhadap_perempuan_mental_15-44", "");
        map.put("jenis_kekerasan_terhadap_perempuan_mental_45-60", "");
        map.put("jenis_kekerasan_terhadap_perempuan_mental_>_60", "");
        map.put("jenis_kekerasan_terhadap_perempuan_fisik__15-44", "");
        map.put("jenis_kekerasan_terhadap_perempuan_fisik__45-60", "");
        map.put("jenis_kekerasan_terhadap_perempuan_fisik__>_60", "");
        map.put("jenis_kekerasan_terhadap_perempuan_emosional_15-44", "");
        map.put("jenis_kekerasan_terhadap_perempuan_emosional_45-60", "");
        map.put("jenis_kekerasan_terhadap_perempuan_emosional_>_60", "");
        map.put("jenis_kekerasan_terhadap_perempuan_penelantaran_15-44", "");
        map.put("jenis_kekerasan_terhadap_perempuan_penelantaran_45-60", "");
        map.put("jenis_kekerasan_terhadap_perempuan_penelantaran_>_60", "");
        map.put("penanganan_puskesmas__rs", "");
        map.put("penanganan_dirujuk", "");
        map.put("penanganan_lain-lain", "");
        return map;
    }
}
